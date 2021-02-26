package before;

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

public class Generics {

    public long beforeGenerics(List accounts) {
        long sum = 0;

        for (Object account : accounts) {
            // have to do check to prevent ClassCastException in runtime
            if (account instanceof Account) {
                sum += ((Account) account).getAmount();
            }
        }

        return sum;
    }

    // with generics we can't pass wrong type - compile time error
    public long withGenerics(List<Account> accounts) {
        long sum = 0;

        for (Account account : accounts) {
            sum += account.getAmount();
        }

        return sum;
    }

    // for example
    private class Account {
        private long amount;

        public long getAmount() {
            return amount;
        }
    }

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
        List<Animal> animalList = new ArrayList<Dog>(); // compile time error
        // 2 example
        List<Animal> animalList1;
        List<Cat> cats = List.of(new Cat[2]);
        animalList1 = cats; // compile time error
        // 3 example
        List<Integer> ints = Arrays.asList(1,2,3);
        List<Number> nums = ints; // compile time error

        // Generics can be covariant with wildcard
        // PECS
        // producer - only get
        List<? extends Animal> animalList2 = new ArrayList<Dog>();
        animalList2.add(new Dog()); // compile time error
        animalList2.add(null);
        Animal animal = animalList2.get(0);

        // And contravariance
        // consumer - only add
        List<? super Dog> animalList3 = new ArrayList<Animal>();
        animalList3.add(new Dog());
        Animal animal1 = animalList3.get(0); // compile time error
        Object object = animalList3.get(0);

        // Raw type = ? extend Object
        List<?> animalList4 = new ArrayList<>();
        animalList4.add(new Dog());
        animalList4.add(null);
        Object o = animalList4.get(0);

    }
}
