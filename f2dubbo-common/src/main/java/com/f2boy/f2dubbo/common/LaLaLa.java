package com.f2boy.f2dubbo.common;

import com.f2boy.f2dubbo.common.util.JsonUtils;

public class LaLaLa {

    private String ss = "123124";

    public static void main(String[] args) {
        System.out.println(JsonUtils.to(new LaLaLa()));
    }

}
