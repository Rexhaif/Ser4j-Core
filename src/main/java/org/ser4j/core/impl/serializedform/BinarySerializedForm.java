package org.ser4j.core.impl.serializedform;

import org.ser4j.core.SerializedForm;

import java.nio.ByteBuffer;
import java.util.Base64;

/**
 * Represents binary-based serialized form
 */
public class BinarySerializedForm implements SerializedForm {

    private byte[] serializedForm;

    /**
     * Creates serialized form from byte array
     * @param serializedForm byte array
     */
    public BinarySerializedForm(byte[] serializedForm) {
        this.serializedForm = serializedForm;
    }

    /**
     * Creates serialized form from base64 encoded byte array
     * @param base64 encoded byte array
     */
    public BinarySerializedForm(String base64) {
        this(Base64.getDecoder().decode(base64));
    }

    @Override
    public byte[] asByteArray() {
        return serializedForm;
    }

    @Override
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(serializedForm);
    }

    @Override
    public String asString() {
        return Base64.getEncoder().encodeToString(serializedForm);
    }
}
