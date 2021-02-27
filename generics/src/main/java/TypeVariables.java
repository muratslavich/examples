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

}
