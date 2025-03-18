package Julian_30.Ejer_24;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface Transformador<T, R> {
    R transformar(T input);
}

