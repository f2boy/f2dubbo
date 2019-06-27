package com.f2boy.f2dubbo.common.serialize.support;

import com.f2boy.f2dubbo.common.serialize.ObjectOutput;
import com.f2boy.f2dubbo.common.util.JsonUtils;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class JsonObjectOutput implements ObjectOutput {

    private PrintWriter writer;

    public JsonObjectOutput(OutputStream os) {
        this.writer = new PrintWriter(new OutputStreamWriter(os));
    }

    @Override
    public void writeObject(Object o) {
        String json = JsonUtils.to(o);
        writer.write(json);
        writer.println();
        writer.flush();
    }

}
