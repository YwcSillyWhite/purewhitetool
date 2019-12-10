package com.purewhile.tool.bar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;

/**
 * 状态栏和导航拦变化
 */
public class BarConfig {

    private Window window;
    private int flag;

    public BarConfig(Activity activity) {
        this.window = activity.getWindow();
        //稳定布局
        flag = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
    }

    //设置状态栏文本颜色
    public BarConfig setStatusBarTextColorFlag(boolean dark) {
        if (dark) {
            flag |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        }
        return this;
    }


    /**
     *  状态栏设计
     * @return
     */
   public BarConfig setStatusBar(@BarType.BarTypeStatue int ...whats) {
        for (int what:whats) {
            switch (what) {
                case BarType.BarType1:
                    //透明状态栏
                    flag |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                    setStatusBarColor(Color.TRANSPARENT);
                    break;
                case BarType.BarType2:
                    //透明导航拦
                    flag |= View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
                    setNavigationBarColor(Color.TRANSPARENT);
                    break;
                case BarType.BarType3:
                    //隐藏状态栏
                    flag |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                    break;
                case BarType.BarType4:
                    //正常模式
                    flag |= View.SYSTEM_UI_FLAG_VISIBLE;
                    break;
                case BarType.BarType5:
                    //View已请求进入正常的全屏模式
                    flag |= View.SYSTEM_UI_FLAG_FULLSCREEN;
                    break;
                case BarType.BarType6:
                    //透明全屏模式
                    flag |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                    flag |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                    setStatusBarColor(Color.TRANSPARENT);
                    setNavigationBarColor(Color.TRANSPARENT);
                    break;
                case BarType.BarType7:
                    //全屏模式
                    flag |= View.SYSTEM_UI_FLAG_FULLSCREEN;
                    flag |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                    flag |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                    setStatusBarColor(Color.TRANSPARENT);
                    setNavigationBarColor(Color.TRANSPARENT);
                    break;

            }
        }
        return this;
    }


    /**
     * 在使用隐藏的导航拦，呼出之后是否改变布局,呼出之后（状态栏和导航拦）是否可以自动消失
     * @param change
     * @return
     */
    public BarConfig setBarChange(boolean change) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            flag |=change?View.SYSTEM_UI_FLAG_IMMERSIVE:View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        }
        return this;
    }


    public BarConfig setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(color);
        }
        return this;
    }

    public BarConfig setNavigationBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setNavigationBarColor(color);
        }
        return this;
    }



    public void build() {
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(flag);
    }

}
