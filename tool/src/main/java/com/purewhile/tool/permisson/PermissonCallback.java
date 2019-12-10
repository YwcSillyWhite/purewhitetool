package com.purewhile.tool.permisson;

import java.util.List;

public interface PermissonCallback {

    /**
     * 权限开启成功
     * @param requestCode
     */
    void permissonSuccess(int requestCode);

    /**
     * 权限开启失败
     * @param requestCode 请求码
     * @param successList 请求成功的权限
     * @param failList 请求失败的权限
     */
    void permissonFail(int requestCode, List<String> successList,List<String> failList);

}
