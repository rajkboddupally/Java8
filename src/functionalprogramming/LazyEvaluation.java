package functionalprogramming;

/* Raj Kumar Boddupally created on 9/8/2021 inside the package - functionalprogramming */

public class LazyEvaluation {
    static final int test;

    //Initialized when class is loaded to JVM - ONE TIME not related to instance
    static {
        test = 10;
        System.out.println("STATIC BLOCK");
        callTest(test);
    }

    public LazyEvaluation() {
        System.out.println("Constructor");
    }

    private static void callTest(int test) {
        System.out.println("callTest " + test);
    }

    public static void main(String[] args) {

        System.out.println("test " + test);

        Function<Integer, Integer> square = new Function<Integer, Integer>() {
            {
                int temp = 5;
                System.out.println("SQUARE");
            }

            public Integer apply(Integer integer) {
                System.out.println("In square");
                return integer * integer;
            }
        };


        Function<Integer, Integer> cube = new Function<Integer, Integer>() {
            {
                System.out.println("CUBE");
            }

            public Integer apply(Integer integer) {
                System.out.println("In cube");
                return integer * integer * integer;
            }
        };

        System.out.println(ifThenElse(true, square, cube, 3));
        System.out.println(ifThenElse(false, square, cube, 3));
    }

    private static int ifThenElse(boolean flag, Function<Integer, Integer> square, Function<Integer, Integer> cube, int t) {
        return flag ? square.apply(t) : cube.apply(t);
    }
}
