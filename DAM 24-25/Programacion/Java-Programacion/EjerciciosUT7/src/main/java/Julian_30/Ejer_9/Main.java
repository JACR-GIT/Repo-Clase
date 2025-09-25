package Julian_30.Ejer_9;

import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) {
        BiPredicate<String, String> mismaLongitud = (s1, s2) -> s1.length() == s2.length();
        System.out.println(mismaLongitud.test("hola", "chau")); // true
        System.out.println(mismaLongitud.test("hola", "adios")); // false
    }
}
