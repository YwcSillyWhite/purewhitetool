package com.purewhile.tool;

import android.os.Bundle;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class BundlerUtils {

    private Bundle bundle;

    public static BundlerUtils wiht(){
        return new BundlerUtils();
    }

    private BundlerUtils(){
        bundle=new Bundle();
    }

    public BundlerUtils put(@NonNull String key, @NonNull Object object){
        if (object instanceof Float){
            bundle.putFloat(key, ((float) object));
        }else if(object instanceof Integer){
            bundle.putInt(key, ((Integer) object));
        }else if (object instanceof Long){
            bundle.putLong(key, ((Long) object));
        }else if (object instanceof Double){
            bundle.putDouble(key, ((Double) object));
        }else if (object instanceof String){
            bundle.putString(key, ((String) object));
        }else if (object instanceof Parcelable){
            bundle.putParcelable(key, ((Parcelable)object));
        }else if (object instanceof Serializable){
            bundle.putSerializable(key, ((Serializable) object));
        }else if (object instanceof Boolean){
            bundle.putBoolean(key, ((Boolean) object));
        }
        return this;
    }

    public BundlerUtils putFloatArray(@NonNull String key,@NonNull float[] value){
        bundle.putFloatArray(key,value);
        return this;
    }



    public BundlerUtils putIntArray(@NonNull String key, @NonNull int[] value){
        bundle.putIntArray(key,value);
        return this;
    }

    public BundlerUtils putIntegerArrayList(@NonNull String key, @NonNull ArrayList<Integer> value){
        bundle.putIntegerArrayList(key,value);
        return this;
    }

    public BundlerUtils putLongArray(@NonNull String key, @NonNull long[] value){
        bundle.putLongArray(key,value);
        return this;
    }


    public BundlerUtils putDoubleArray(@NonNull String key, @NonNull double[] value){
        bundle.putDoubleArray(key,value);
        return this;
    }


    public BundlerUtils putBooleanArray(@NonNull String key, @NonNull boolean[] value){
        bundle.putBooleanArray(key,value);
        return this;
    }

    public BundlerUtils putStringArray(@NonNull String key, @NonNull String[] value){
        bundle.putStringArray(key,value);
        return this;
    }

    public BundlerUtils putStringArrayList(@NonNull String key, @NonNull ArrayList<String> value){
        bundle.putStringArrayList(key,value);
        return this;
    }

    public BundlerUtils putParcelableArray(@NonNull String key, @NonNull Parcelable[] value){
        bundle.putParcelableArray(key,value);
        return this;
    }

    public BundlerUtils putParcelableArrayList(@NonNull String key, @NonNull ArrayList<? extends Parcelable> value){
        bundle.putParcelableArrayList(key,value);
        return this;
    }

    public Bundle build(){
        return bundle;
    }

}
