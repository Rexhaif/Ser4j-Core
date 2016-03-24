package org.ser4j.core;

/**
 * Describes java object serializer api
 */
public interface Serializer {

    /**
     * Deserialize object from serialized from
     * @param serializedForm serialized form
     * @param tClass object class
     * @param <T> object type
     * @return deserialized object
     */
    <T> T deserialize(SerializedForm serializedForm, Class<T> tClass);

    /**
     * Serialize object into binary form
     * @param object object
     * @param <T> object type (optional)
     * @return serialized form of object
     */
    <T> SerializedForm serialize(T object);
}
