package src;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Random;

public class RandomAnnotitionProcessor {
    public static void processAnnotation(Object object) {
        java.util.Random rand = new java.util.Random();
        Class<?> obj = object.getClass();
        for (java.lang.reflect.Field f : obj.getDeclaredFields()) {
            if (f.isAnnotationPresent(RandomDate.class)) {
                try {
                    f.setAccessible(true);
                    RandomDate annotation = f.getAnnotation(RandomDate.class);
                    long min = annotation.min();
                    long max = annotation.max();
                    if (min >= max) {
                        System.err.println("Некорректный диапазон " + f.getName());
                        continue;
                    }
                    long randomDate = min + (long) (rand.nextDouble() * (max - min));
                    f.set(object, new Date(randomDate));
                } catch (IllegalAccessException e) {
                    System.err.println("Не удалось вставить значение в поле!");
                }
            }
        }
    }
}
