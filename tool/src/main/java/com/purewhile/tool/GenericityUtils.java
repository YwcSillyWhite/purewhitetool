package com.purewhile.tool;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 泛型工具类
 */
public class GenericityUtils {



    public static <T> T obtainT(Object object, int position) {
        if (object!=null){
            try{
                Class<?> cla = object.getClass();
                if (cla!=null){
                    Type type = cla.getGenericSuperclass();
                    if (type!=null && type instanceof ParameterizedType){
                        Type[] types = ((ParameterizedType) type).getActualTypeArguments();
                        if (types!=null && types.length>position){
                            return  ((Class<T>) types[position]).newInstance();
                        }
                    }
                }
            }catch (Exception e){

            }
        }
        return null;
    }
}
