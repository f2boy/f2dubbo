package com.f2boy.f2dubbo.common.serialize;

import com.f2boy.f2dubbo.common.SimpleObject;
import com.f2boy.f2dubbo.common.serialize.support.JsonSerialization;
import com.f2boy.f2dubbo.common.util.JsonUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Random;

public class TestJsonSerialization {

    private Serialization serialization;

    @Before
    public void setup() throws Exception {
        serialization = new JsonSerialization();
    }

    @Test
    public void testSerialize() throws Exception {
        OutputStream os = new FileOutputStream("D:/aaaa.txt");
        ObjectOutput output = serialization.serialize(os);

        for (int i = 0; i < 5; i++) {
            SimpleObject a = new SimpleObject();
            a.setIntV(100 + new Random().nextInt(900));
            a.setDoubleV(123.32);
            a.setStrV("sssss");
            a.setDateV(new SimpleDateFormat(JsonUtils.DEFAULT_DATE_FORMAT).parse("2019-07-01 18:23:56"));

            output.writeObject(a);
        }
        os.close();
    }

    @Test
    public void testDeserialize() throws Exception {
        InputStream is = new FileInputStream("D:/aaaa.txt");
        ObjectInput input = serialization.deserialize(is);

        Object object = input.readObject(SimpleObject.class);
        System.out.println(JsonUtils.to(object));

        while ((object = input.readObject()) != null) {
            System.out.println(JsonUtils.to(object));
        }
    }

}
