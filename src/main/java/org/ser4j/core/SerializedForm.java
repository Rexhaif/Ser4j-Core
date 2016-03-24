package org.ser4j.core;

import java.nio.ByteBuffer;

/**
 * Represents serialized form of object
 */
public interface SerializedForm {

    /**
     * Retrieves direct binary representation of object
     * @return binary representation of object
     */
    byte[] asByteArray();

    /**
     * Retrieves byte-buffer backed binary representation of object
     * @return binary representation of object
     */
    ByteBuffer asByteBuffer();

    /**
     * Retrieves string representation of object
     * @return string (or Base64 encoded binary) representation of object
     */
    String asString();

}
