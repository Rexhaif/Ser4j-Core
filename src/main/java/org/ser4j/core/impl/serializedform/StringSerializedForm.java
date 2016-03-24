package org.ser4j.core.impl.serializedform;

import org.ser4j.core.SerializedForm;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Represents string-based serialized form
 */
public class StringSerializedForm implements SerializedForm {

    private Charset charset;
    private String serializedForm;

    /**
     * Creates serialized form
     * @param serializedForm string serialized form
     * @param charset string charset
     */
    public StringSerializedForm(String serializedForm, Charset charset) {
        this.charset = charset;
        this.serializedForm = serializedForm;
    }

    /**
     * Creates serialized form with UTF-8 charset
     * @param serializedForm serialized form
     */
    public StringSerializedForm(String serializedForm) {
        this(serializedForm, StandardCharsets.UTF_8);
    }

    /**
     * Creates serialized form from string bytes and charset
     * @param bytes string bytes
     * @param charset charset
     */
    public StringSerializedForm(byte[] bytes, Charset charset) {
        this(new String(bytes, charset), charset);
    }

    /**
     * Creates serialized form with UTF-8 charset
     * @param bytes string bytes
     */
    public StringSerializedForm(byte[] bytes) {
        this(new String(bytes, StandardCharsets.UTF_8));
    }

    @Override
    public byte[] asByteArray() {
        return serializedForm.getBytes(charset);
    }

    @Override
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(serializedForm.getBytes(charset));
    }

    @Override
    public String asString() {
        return serializedForm;
    }
}
