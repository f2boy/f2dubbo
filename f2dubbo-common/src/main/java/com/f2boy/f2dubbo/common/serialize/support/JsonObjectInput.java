package com.f2boy.f2dubbo.common.serialize.support;

import com.f2boy.f2dubbo.common.serialize.ObjectInput;
import com.f2boy.f2dubbo.common.util.JsonUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class JsonObjectInput implements ObjectInput {

    private BufferedReader reader;

    public JsonObjectInput(InputStream is) {
        this.reader = new BufferedReader(new InputStreamReader(is));
    }

    @Override
    public Object readObject() {
        if (this.reader == null)
            return null;

        try {
            String line = this.reader.readLine();
            return JsonUtils.from(line, Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T readObject(Class<T> c) {
        if (this.reader == null)
            return null;

        try {
            String line = this.reader.readLine();
            return JsonUtils.from(line, c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
