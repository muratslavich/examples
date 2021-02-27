

public class Restrictions {
/**
    public static void main(String[] args) {

        // 1. Cannot use with primitives
        List<int> list = new ArrayList<>();

        // 5. Cannot create arrays of parametrized types
        List<Integer>[] arrayOfLists = new List<Integer>[2];  // compile-time error
    }

    // 2. Cannot create instance of type
    public static <E> void append(List<E> list) {
        E elem = new E();  // compile-time error
        list.add(elem);
    }

    // 2! workaround through reflection
    @SneakyThrows
    public static <E> void append(List<E> list, Class<E> cls) {
        E elem = cls.getDeclaredConstructor().newInstance(); // OK
        list.add(elem);
    }

    // 3. Cannot declare generic static field
    public static class Ex<T> {
        private static T value;
    }

    // 4. Cannot use casts or instanceOf - because of type erasure in runtime
    public static <E> void rtti(List<E> list) {
        if (list instanceof ArrayList<Integer>) {  // compile-time error
            // ...
        }

        List<Integer> li = new ArrayList<>();
        List<Number>  ln = (List<Number>) li;  // compile-time error
    }

    public static void rtti(List<?> list) {
        if (list instanceof ArrayList<?>) {  // OK; instanceof requires a reifiable type
            // ...
        }
    }

    // 6. Cannot use with Exceptions
    static class MathException<T> extends Exception {  }    // compile-time error
    static class MathException2<T> extends Throwable {  }    // compile-time error

    // 6.1 Cannot catch parametrized exception
    public static <T extends Exception, J> void execute(List<J> jobs) {
        try {
            for (J job : jobs) { } // ...
        } catch (T e) {   // compile-time error
            // ...
        }
    }

    // 6.2 But you can use parameter in throws clause
    class Parser<T extends Exception> {
        public void parse(File file) throws T { } // OK
    }

    // 7. Cannot overload method with same type after erasure
    public void print(Set<String> strSet) { }
    public void print(Set<Integer> intSet) { }
*/
}
