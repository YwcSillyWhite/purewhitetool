package com.purewhile.tool.event;

public class EventBean<T> {
    private int code;
    private String content;
    private T t;

    public int getCode() {
        return code;
    }

    public EventBean<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getContent() {
        return content;
    }

    public EventBean<T> setContent(String content) {
        this.content = content;
        return this;
    }

    public T getT() {
        return t;
    }

    public EventBean<T> setT(T t) {
        this.t = t;
        return this;
    }
}
