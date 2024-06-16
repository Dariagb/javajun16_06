import src.ObjektCreator;
import src.Random1;
import src.RandomDate;


public class AnnotationMain {
    public static void main(String[] args) {
        Person person = new Person();
//        person.age=25;
        System.out.println(person.getAge());
        Person rndPerson = ObjektCreator.createObjekt(Person.class, RandomAnnotationProcessor);
//        RandomAnnotitionProcessor.processAnnotition(person);
        System.out.println(person.getAge());
        System.out.println("age1" + rndPerson.age1);
        System.out.println("age2" + rndPerson.age2);


    }

    public static class Person {
        @Random1(min = 1, max = 100)
        @RandomDate private int age1;

        @Random1(min = 50, max = 52)
        private int age2;

        public int getAge() {
            return age1;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age1 +
                    '}';
        }
    }
}
