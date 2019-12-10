package com.purewhile.tool;

import android.text.TextUtils;

import java.text.DecimalFormat;

/**
 * 字符串判断或者转换工具类
 */
public class StringUtils {


    /**
     * 字符串转换双精度
     * @param content
     * @return
     */
    public static double stringToDouble(String content){
        if (TextUtils.isEmpty(content))
            return 0;
        try{
            double num = Double.valueOf(content);
            return num;
        }catch (Exception e){

        }
        return 0;
    }


    /**
     * 字符串转单精度
     * @param content
     * @return
     */
    public static float stringToFloat(String content){
        if (TextUtils.isEmpty(content))
            return 0;
        try{
            float num = Float.valueOf(content);
            return num;
        }catch (Exception e){

        }
        return 0;
    }


    /**
     * 字符串转长整型
     * @param content
     * @return
     */
    public static long stringToLong(String content){
        if (TextUtils.isEmpty(content))
            return 0;
        try{
            long num = Long.valueOf(content);
            return num;
        }catch (Exception e){

        }
        return 0;
    }


    /**
     * 字符串转整型
     * @param content
     * @return
     */
    public static int stringToInt(String content){
        if (TextUtils.isEmpty(content))
            return 0;
        try{
            int num = Integer.valueOf(content);
            return num;
        }catch (Exception e){

        }
        return 0;
    }


    /**
     * 单精度或者双进度 保留小数
     * @param decimalNum  保留几位小数
     * @param num         数值
     * @return
     */
    public static String doubleToString(int decimalNum,double num){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("0");
        if (decimalNum>0){
            stringBuilder.append(".");
            for (int i = 0; i < decimalNum; i++) {
                stringBuilder.append("0");
            }
        }
        return new DecimalFormat(stringBuilder.toString()).format(num);
    }


}
