package com.purewhile.tool.event;

import androidx.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;

/**
 * eventbus工具类
 */
public class EventUtils {

    //注册
    public static void register(@NonNull Object object){
        EventBus.getDefault().register(object);
    }

    //取消注册
    public static void unregister(@NonNull Object object){
        EventBus.getDefault().unregister(object);
    }


    //发送
    public static void post(int code,String content){
        post(code,content,null);
    }

    public static void post(int code,Object object){
        post(code,null,object);
    }

    public static void post(int code,String content,Object object){
        EventBean eventBean = new EventBean();
        eventBean.setCode(code);
        eventBean.setContent(content);
        if (object!=null)
            eventBean.setT(object);
    }

    public static void post(@NonNull EventBean eventBean){
        if (eventBean!=null){
            EventBus.getDefault().post(eventBean);
        }
    }



    public static void postSticky(int code,String content){
        post(code,content,null);
    }

    public static void postSticky(int code,Object object){
        post(code,null,object);
    }

    public static void postSticky(int code,String content,Object object){
        EventBean eventBean = new EventBean();
        eventBean.setCode(code);
        eventBean.setContent(content);
        if (object!=null)
            eventBean.setT(object);
    }

    public static void postSticky(@NonNull EventBean eventBean){
        if (eventBean!=null){
            EventBus.getDefault().postSticky(eventBean);
        }
    }
}
