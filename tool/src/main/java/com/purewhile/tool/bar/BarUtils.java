package com.purewhile.tool.bar;

import android.app.Activity;

/**
 * 状态栏工具类
 * @author yuwenchao
 */
public class BarUtils {

    //在没有bar设置高度
    public static TitleConfig withTitle() {
       return new TitleConfig();
    }

    //设置bar
    public static BarConfig withBar(Activity activity) {
        return new BarConfig(activity);
    }









}
