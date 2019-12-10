package com.purewhile.tool;

import android.view.View;

/**
 * 点击事件帮助类
 */
public class ClickUtils {

    public static boolean clickAble(View view){
        return clickAble(view,600);
    }


    /**
     *
     * @param view
     * @param intervalTime 间隔时间
     * @return true 可以点击
     */
    public static boolean clickAble(View view,int intervalTime){
        Object tag = view.getTag();
        if (tag == null){
            long newTime = System.currentTimeMillis();
            view.setTag(newTime);
        }else if (tag instanceof Long){
            long newTime = System.currentTimeMillis();
            long oldTime = ((Long) tag);
            if (newTime - oldTime >= intervalTime){
                view.setTag(newTime);
            }else{
                return false;
            }
        }
        return true;
    }
}
