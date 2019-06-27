package com.f2boy.f2dubbo.common.serialize.support;

import com.f2boy.f2dubbo.common.serialize.ObjectInput;
import com.f2boy.f2dubbo.common.serialize.ObjectOutput;
import com.f2boy.f2dubbo.common.serialize.Serialization;

import java.io.InputStream;
import java.io.OutputStream;

public class JsonSerialization implements Serialization {
    @Override
    public ObjectOutput serialize(OutputStream os) {
        return new JsonObjectOutput(os);
    }

    @Override
    public ObjectInput deserialize(InputStream is) {
        return new JsonObjectInput(is);
    }
}
