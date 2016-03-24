package org.ser4j.core.impl.serializer;

import org.ser4j.core.SerializedForm;
import org.ser4j.core.Serializer;
import org.ser4j.core.impl.serializedform.BinarySerializedForm;

import java.io.*;
import java.util.function.Consumer;

/**
 * Wrapper around jdk serialization
 */
public class JdkSerializer implements Serializer {

    private Consumer<Throwable> exceptionCallback;

    public JdkSerializer(Consumer<Throwable> exceptionCallback) {
        this.exceptionCallback = exceptionCallback;
    }

    public JdkSerializer() {
        this.exceptionCallback = Throwable::printStackTrace;
    }

    @Override
    public <T> T deserialize(SerializedForm serializedForm, Class<T> tClass) {
        ObjectInput input = null;
        T object = null;
        try {
            input = new ObjectInputStream(new ByteArrayInputStream(serializedForm.asByteArray()));
            object = (T) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            exceptionCallback.accept(e);
        }

        return object;

    }

    @Override
    public <T> SerializedForm serialize(T object) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutput output = null;
        try {
            output = new ObjectOutputStream(out);
            output.writeObject(object);
        } catch (IOException e) {
            exceptionCallback.accept(e);
        }

        return new BinarySerializedForm(out.toByteArray());

    }


}
