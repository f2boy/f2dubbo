package com.f2boy.f2dubbo.common.serialize;

public interface ObjectInput {
    Object readObject();

    <T> T readObject(Class<T> c);
}
