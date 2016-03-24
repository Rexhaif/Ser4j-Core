package org.ser4j.core;

import org.ser4j.core.impl.serializer.JdkSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry for serializers
 */
public class Serializers {

    private static Map<String, Serializer> serializers = new HashMap<>();

    /**
     * Statically add available serializers
     */
    static {
        addSerializer("jdk/serialization", new JdkSerializer());
    }

    /**
     * Finds and retrieves serializer for given name
     * @param name serializer name
     * @return serializer
     */
    public static Serializer forName(String name) {
        return serializers.get(name);
    }

    /**
     * Adds serializer to registry
     * @param name serializer name
     * @param serializer serializer
     */
    public static void addSerializer(String name, Serializer serializer) {
        serializers.put(name, serializer);
    }

    /**
     * Imports serializers from map
     * @param serializers serializers
     */
    public static void addAll(Map<String, Serializer> serializers) {
        serializers.putAll(serializers);
    }

    /**
     * Exports serializers into map
     * @return serializers
     */
    public static Map<String, Serializer> getSerializers() {
        return serializers;
    }

}
