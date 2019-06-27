package com.f2boy.f2dubbo.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class JsonUtils {

    private JsonUtils() {
    }

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static <T> T from(String json, Class<T> c) {
        return from(json, c, DEFAULT_DATE_FORMAT);
    }

    public static <T> T from(String json, Class<T> c, String dateFormat) {
        Gson gson = new GsonBuilder().setDateFormat(dateFormat).create();
        return gson.fromJson(json, c);
    }

    public static String to(Object o) {
        return to(o, DEFAULT_DATE_FORMAT);
    }

    public static String to(Object o, String dateFormat) {
        Gson gson = new GsonBuilder().setDateFormat(dateFormat).create();
        return gson.toJson(o);
    }

}
