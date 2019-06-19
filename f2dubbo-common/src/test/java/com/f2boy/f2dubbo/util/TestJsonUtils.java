package com.f2boy.f2dubbo.util;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestJsonUtils {

    @Test
    public void test() throws Exception {
        String dateFormat = "yyyy-MM-dd HH:mm:ss";

        SimpleObject a = new SimpleObject();
        a.setIntV(100);
        a.setDoubleV(123.32);
        a.setStrV("sssss");
        a.setDateV(new SimpleDateFormat(dateFormat).parse("2019-07-01 18:23:56"));

        String json = JsonUtils.to(a);
        System.out.println(json);

        SimpleObject b = JsonUtils.from(json, SimpleObject.class);
        assertEquals(a.getIntV(), b.getIntV());
        assertEquals(a.getStrV(), b.getStrV());
        assertEquals(a.getDateV().getTime(), b.getDateV().getTime());
        assertEquals(a.getDoubleV(), b.getDoubleV(), 0.001);
    }

    @Getter
    @Setter
    static class SimpleObject {
        private int intV;
        private String strV;
        private Date dateV;
        private double doubleV;
    }

}
