import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws Exception {
        Person unnamed = new Person();
        Person persen = new Person("newPerson" );
        System.out.println(unnamed);
        System.out.println(persen);
        Class<Person> personClass = Person.class;
       Class<? extends Person> aClass = unnamed.getClass();
       Constructor<Person> constructor = personClass.getConstructor(String.class);
        Person person2 = constructor.newInstance("via");
        System.out.println(person2);

        System.out.println(unnamed.getName());

        Method getName=Person.class.getMethod("getName");
        System.out.println(getName.invoke(unnamed));
        System.out.println(getName.invoke(person2));

        Method setAge=Person.class.getMethod("setAge", int.class);
        setAge.invoke(unnamed,20);
        System.out.println(unnamed);
        System.out.println("Counter"+Person.getCounter());
        Method getCounter=Person.class.getMethod("getCounter");
        System.out.println(getCounter.invoke(null));

        Field field=Person.class.getDeclaredField("name");
       // System.out.println(name.get(unnamed));

        System.out.println("---------");
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            for (Class<?> parameterType : declaredConstructor.getParameterTypes()) {
                System.out.println(parameterType);
            }
            System.out.println("----------------");
        }
    }

    private static class Person {
        private final String name;

        private int age;
        private static long counter = 0L;
        public Person(String name) {
            this.name = name;
            counter++;
        }
        public Person(){
            this("unnamed");
        }

        public String getName() {
            return name;
        }
        public static long getCounter() {
            return counter;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Persen{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    }
