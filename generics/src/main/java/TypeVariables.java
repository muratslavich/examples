import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

public class TypeVariables {

    // type variable in declaring a class or method - <T extends Object & Comparable<T>>
    // could be bounded only on top (extends) - <T extends Comparable<T>>
    // multiple bounds - left bound is used for type erasure
    public static <T extends Object & Comparable<T>> T max(Collection<T> coll) {
        T candidate = coll.iterator().next();
        for (T elt : coll) {
            if (candidate.compareTo(elt) < 0) candidate = elt;
        }
        return candidate;
    }


    @Getter
    @Setter
    static class Generic<T> {
        private T value;
    }

    // type variable doesn't check producing or consuming restrictions (only wildcard do).
    static class Producer<T extends Comparable<T>> {
        private T value;

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Generic<String> generic = new Generic<>();
        generic.setValue("example");
        generic.getValue();

        Producer<String> producer = new Producer<>();
        producer.setValue("example");
        producer.getValue();
    }

}
