package com.purewhile.tool.bar;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class BarType {
    @IntDef({BarType1, BarType2, BarType3,BarType4,BarType5,BarType6,BarType7,0})
    @Retention(RetentionPolicy.SOURCE)
    public @interface BarTypeStatue {}

    public final static int BarType1 = 1;
    public final static int BarType2 = 2;
    public final static int BarType3 = 3;
    public final static int BarType4 = 4;
    public final static int BarType5 = 5;
    public final static int BarType6 = 6;
    public final static int BarType7 = 7;
}
