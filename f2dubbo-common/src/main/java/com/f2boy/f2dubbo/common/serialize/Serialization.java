package com.f2boy.f2dubbo.common.serialize;

import java.io.InputStream;
import java.io.OutputStream;

public interface Serialization {

    ObjectOutput serialize(OutputStream os);

    ObjectInput deserialize(InputStream is);

}
