# Serializers for Java #

##### Simple serialization api on top of many available serialization mechanisms and formats #####
##### Note, that this is core module and provide only basic functionality (JDK-based serializer "jdk/serialization") #####
##### Other formats and mechanisms are available in ser4j-impl module (that will be added as soon as possible) #####
<hr /><hr />
## Usage: ##
```java

Serializer serializer = Serializers.forName("jdk/serialization");
System.out.println(serializer.serialize(ManagementFactory.getOperatingSystemMXBean()).asString());

```
