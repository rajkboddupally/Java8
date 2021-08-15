package functionalprogramming;

/* Raj Kumar Boddupally created on 8/14/2021 inside the package - functionalprogramming */

interface Function<T, R> {
    R apply(T t);
}

public class PureFunction {

    static Function<Integer, Integer> function = new Function<Integer, Integer>() {
        public Integer apply(Integer integer) {
            return new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}[integer - 1];
        }
    };

    public static void main(String[] args) {
        System.out.println(function.apply(3));
        System.out.println(function.apply(11));
    }
}
