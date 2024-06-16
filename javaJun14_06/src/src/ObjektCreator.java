package src;

import java.lang.reflect.Constructor;

public class ObjektCreator {
    public static <T> T createObjekt(Class<T> clazz, RandomAnnotationProcessor randomAnnotationProcessor) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            T obj = clazz.newInstance();
            randomAnnotationProcessor.processAnnotation(obj);
            return obj;
        } catch (Exception e) {
            System.err.println("Ничего не получилось");
            return null;
        }
    }
}

