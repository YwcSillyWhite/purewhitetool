package com.purewhile.tool.permisson;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class PermissonUtils {
    private PermissonCallback permissonCallback;
    private Activity activity;
    private Fragment fragment;
    private boolean isActivity;

    public static PermissonUtils with(Activity activity,PermissonCallback permissonCallback){
        return new PermissonUtils(activity,null,true,permissonCallback);
    }

    public static PermissonUtils with(Fragment fragment,PermissonCallback permissonCallback){
        return new PermissonUtils(null,fragment,false,permissonCallback);
    }

    private PermissonUtils(Activity activity,Fragment fragment,boolean isActivity,PermissonCallback permissonCallback) {
        if (isActivity){
            this.activity=activity;
        }else{
            this.fragment=fragment;
        }
        this.permissonCallback=permissonCallback;
    }


    /**
     * 判断权限是否打开
     * @param permisson
     * @return true权限打开 false没有打开
     */
    public boolean havePermisson(String permisson){
        if (isActivity){
            return ContextCompat.checkSelfPermission(activity,permisson)== PackageManager.PERMISSION_GRANTED;
        }else{
            return ContextCompat.checkSelfPermission(fragment.getContext(),permisson)== PackageManager.PERMISSION_GRANTED;
        }
    }

    /**
     *
     * @param permissons 权限
     * @return 长度等于0打开,长度并不等于0 没有打开
     */
    public List<String> havePermissons(String ...permissons){
        List<String> perList=new ArrayList<>();
        if (permissons!=null && permissons.length>0){
            for (int i = 0; i < permissons.length; i++) {
                String permisson = permissons[i];
                if (!havePermisson(permisson)){
                    perList.add(permisson);
                }
            }
        }
        return perList;
    }

    /**
     *
     * @param perList 未开启的权限
     * @return true权限打开 false没有打开
     */
    public boolean havePermissons(List<String> perList){
        if (perList!=null && perList.size()>0){
            return false;
        }
        return true;
    }

    /**
     * 开启权限请求
     */
    public void startPermisson(int requestCode,String ...permissons){
        //Android 6.0才有权限申请
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            List<String> perList = havePermissons(permissons);
            if (havePermissons(perList)){
                if (permissonCallback!=null){
                    permissonCallback.permissonSuccess(requestCode);
                }
            }else{
                requestPermissons(requestCode,perList);
            }
        }else{
            if (permissonCallback!=null){
                permissonCallback.permissonSuccess(requestCode);
            }
        }
    }


    /**
     * 请求开启权限
     * @param requestCode 请求码
     * @param perList     未打开的权限
     */
    public void requestPermissons(int requestCode,List<String> perList) {
        if (perList!=null && perList.size()>0){
            String[] permissons = perList.toArray(new String[perList.size()]);
            requestPermissons(requestCode,permissons);
        }
    }
    /**
     * 请求开启权限
     * @param requestCode 请求码
     * @param permissons  未打开的权限
     */
    public void requestPermissons(int requestCode,String ...permissons){
        if (permissons!=null && permissons.length>0){
            if (isActivity){
                ActivityCompat.requestPermissions(activity,permissons,requestCode);
            }else{
                fragment.requestPermissions(permissons,requestCode);
            }
        }
    }



    public void disposePermissons(int requestCode,String[] permissons,int[] grantResults){
        if (permissonCallback == null)
            return;
        if (grantResults!=null && grantResults.length>0){
            List<String> successList = new ArrayList<>();
            List<String> failList = new ArrayList<>();
            for (int i = 0; i < grantResults.length;i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    successList.add(permissons[i]);
                }else{
                    failList.add(permissons[i]);
                }
            }
            if (failList.size()>0){
                permissonCallback.permissonFail(requestCode,successList,failList);
            }else{
                permissonCallback.permissonSuccess(requestCode);
            }
        }
    }
}
