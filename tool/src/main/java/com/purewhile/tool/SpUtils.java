package com.purewhile.tool;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import java.util.Set;

/**
 * 存储数据工具类
 */
public class SpUtils {


    private  SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;

    public  static SpUtils with(Context context){
        return with(context,"purewhite");
    }

    public static SpUtils with(Context context,@NonNull String name){
        return with(context,name,Context.MODE_PRIVATE);
    }

    public static SpUtils with(Context context,@NonNull String name,int mode){
        return new SpUtils(context,name,mode);
    }

    private SpUtils(Context context,@NonNull String name, int mode){
        sharedPreferences = context.getSharedPreferences(name, mode);
    }

    //获取edit
    public SpUtils edit(){
        edit = sharedPreferences.edit();
        return this;
    }

    //存放
    public SpUtils put(String key,@NonNull Object object){
        if (edit!=null){
            if (object instanceof Integer){
                edit.putInt(key, ((Integer) object));
            }else if (object instanceof Float){
                edit.putFloat(key, ((Float) object));
            }else if (object instanceof Long){
                edit.putLong(key, ((Long) object));
            }else if (object instanceof Boolean){
                edit.putBoolean(key, ((Boolean) object));
            }else if (object instanceof String){
                edit.putString(key, ((String) object));
            }else if (object instanceof Set){
                edit.putStringSet(key,(Set) object);
            }
        }
        return this;
    }


    //获取int
    public int getInt(String key){
        return getInt(key,0);
    }
    public int getInt(String key,int defValue){
        return sharedPreferences.getInt(key,defValue);
    }


    //获取float
    public float getFloat(String key){
        return getFloat(key,0);
    }
    public float getFloat(String key,float defValue){
        return sharedPreferences.getFloat(key,defValue);
    }

    //获取long
    public Long getDouble(String key){
        return getDouble(key,0);
    }
    public Long getDouble(String key,long defValue){
        return sharedPreferences.getLong(key,defValue);
    }

    //获取boolean
    public boolean getBoolean(String key){
        return getBoolean(key,false);
    }
    public boolean getBoolean(String key,boolean defValue){
        return sharedPreferences.getBoolean(key,defValue);
    }

    //获取String
    public String getString(String key){
        return getString(key,"");
    }
    public String getString(String key,String defValue){
        return sharedPreferences.getString(key,defValue);
    }

    public Set<String> getSet(String key,Set<String> defValue){
        return sharedPreferences.getStringSet(key,defValue);
    }


    //移除
    public SpUtils remove(String key){
        if (edit!=null){
            edit.remove(key);
        }
        return this;
    }

    //移除
    public SpUtils removes(String ...keys){
        if (keys!=null && keys.length>0){
            for (int i = 0; i < keys.length; i++) {
                remove(keys[i]);
            }
        }
        return this;
    }

    //清空
    public SpUtils clear(){
        if (edit!=null){
            edit.clear();
        }
        return this;
    }

    //提交
    public void commite(){
        if (edit!=null){
            edit.commit();
        }
    }

    //提交
    public void apply(){
        if (edit!=null){
            edit.apply();
        }
    }


}
