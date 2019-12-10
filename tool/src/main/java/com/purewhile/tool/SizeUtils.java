package com.purewhile.tool;

import android.content.Context;

/**
 * 尺寸获取工具类
 */
public class SizeUtils {

    /**
     *dp转换px
     * @param context
     * @param dpValue
     * @return
     */
    public static float dpToPx(Context context, float dpValue){
        float density = context.getResources().getDisplayMetrics().density;
        return dpValue * density + 0.5f;
    }

    /**
     * px转换成dp
     * @param context
     * @param pxValue
     * @return
     */
    public static float pxToDp(Context context,float pxValue){
        float density = context.getResources().getDisplayMetrics().density;
        return pxValue / density + 0.5f;
    }


    /**
     * 获取屏幕的宽度
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕的高
     * @return
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }


}
