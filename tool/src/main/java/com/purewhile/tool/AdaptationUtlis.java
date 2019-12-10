package com.purewhile.tool;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

import androidx.annotation.NonNull;

/**
 * 今日头条适配
 *
 * px = dp * density;
 * density = dpi / 160;
 */
public class AdaptationUtlis {
    private static float appDensity,appScaleDensity;;

    /**
     * 根据宽适配
     * @param application
     * @param activity
     * @param dip
     */
    public static void  adaptiveWitgh(final Application application, Activity activity, float dip){
        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        if (appDensity == 0){
            appDensity = displayMetrics.density;
            appScaleDensity = displayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(@NonNull Configuration newConfig) {
                    if (newConfig!=null && newConfig.fontScale>0){
                        appScaleDensity = application.getResources()
                                .getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }

        float targetDensity = displayMetrics.widthPixels / dip ;
        float targetScaleDentisty = targetDensity * appScaleDensity / appDensity;
        int targetDpi = ((int) (targetDensity * 160));
        displayMetrics.density = targetDensity;
        displayMetrics.scaledDensity = targetScaleDentisty;
        displayMetrics.densityDpi = ( targetDpi);

        DisplayMetrics aDisplayMetrics = activity.getResources().getDisplayMetrics();
        aDisplayMetrics.density = targetDensity;
        aDisplayMetrics.scaledDensity = targetScaleDentisty;
        aDisplayMetrics.densityDpi = ( targetDpi);
    }


    /**
     * 根据高适配
     * @param application
     * @param activity
     * @param dip
     */
    public static void  adaptiveHeight(final Application application, Activity activity, float dip){
        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        if (appDensity == 0){
            appDensity = displayMetrics.density;
            appScaleDensity = displayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(@NonNull Configuration newConfig) {
                    if (newConfig!=null && newConfig.fontScale>0){
                        appScaleDensity = application.getResources()
                                .getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }

        float targetDensity = displayMetrics.heightPixels / dip ;
        float targetScaleDentisty = targetDensity * appScaleDensity / appDensity;
        int targetDpi = ((int) (targetDensity * 160));
        displayMetrics.density = targetDensity;
        displayMetrics.scaledDensity = targetScaleDentisty;
        displayMetrics.densityDpi = ( targetDpi);

        DisplayMetrics aDisplayMetrics = activity.getResources().getDisplayMetrics();
        aDisplayMetrics.density = targetDensity;
        aDisplayMetrics.scaledDensity = targetScaleDentisty;
        aDisplayMetrics.densityDpi = ( targetDpi);

    }
}
