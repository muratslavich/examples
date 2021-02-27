import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* Animal -> Cat
*
* Covariance - keep original hierarchy - Set<Animal> = Set<Cat>
* Contravariance - inverting hierarchy in derived types - Set<Cat> = Set<Animal>
* Invariance - no inheritance between derived types -  Set<Animal> != Set<Cat>
* */

public class Wildcards {

    private static class Animal { }

    private static class Cat extends Animal {  }
    private static class Dog extends Animal {  }


    public static void main(String[] args) {

        // Arrays in Java are covariant
        Animal[] animals = new Cat[10];
        animals[0] = new Cat();
        animals[1] = new Dog(); // ArrayStoreException in runtime

        // Generics are invariant
        // 1 example
//        List<Animal> animalList = new ArrayList<Dog>(); // compile time error
        // 2 example
        List<Animal> animalList1;
        List<Cat> cats = List.of(new Cat[2]);
//        animalList1 = cats; // compile time error
        // 3 example
        List<Integer> ints = Arrays.asList(1,2,3);
//        List<Number> nums = ints; // compile time error

        // Generics can be covariant with wildcard
        // PECS
        // producer - only get
        List<? extends Animal> animalList2 = new ArrayList<Dog>();
//        animalList2.add(new Dog()); // compile time error
        animalList2.add(null);
        Animal animal = animalList2.get(0);

        // And contravariance
        // consumer - only add
        List<? super Dog> animalList3 = new ArrayList<Animal>();
        animalList3.add(new Dog());
//        Animal animal1 = animalList3.get(0); // compile time error
        Object object = animalList3.get(0);

        // Raw type = ? extend Object
        List<?> animalList4 = new ArrayList<>();
//        animalList4.add(new Dog());
        animalList4.add(null);
        Object o = animalList4.get(0);

    }


    // Cannot list.set() because ? is equal <? extend Object>
    public static void reverse(List<?> list) {
        List<Object> tmp = new ArrayList<Object>(list);
        for (int i = 0; i < list.size(); i++) {
//            list.set(i, tmp.get(list.size()-i-1)); // compile-time error
        }
    }

    // Wildcard capture
    public static void reverse1(List<?> list) {
        rev(list);
    }

    public static <T> void rev(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size()-i-1)); // compile-time error
        }
    }





    //--------------------------------Examples----------------------------------------
    public static void copy(List<?> src, List<?> dest) {
        Collections.<Integer>copy(List.of(""), null);
    }

}
