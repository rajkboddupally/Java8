package map;/* Raj Kumar Boddupally created on 8/10/2021 inside the package - map */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

// Write your code here. DO NOT use an access modifier in your class declaration.
class Parser {
    static boolean isBalanced(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(')
                stack.push(c);
            else if (!stack.isEmpty()) {
                char ch = stack.pop();
                if (ch != map.get(c))
                    return false;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

}

public class Solution {
    /*
        public static void main(String[] args) {
            Parser parser = new Parser();

            Scanner in = new Scanner(System.in);

            while (in.hasNext()) {
                System.out.println(parser.isBalanced(in.next()));
            }

            in.close();
        }
    */
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int counter = 0;
        while (in.hasNext()) {
            args[counter++] = in.next();
        }
        Solution sol = new Solution();
        if (Character.isDigit(args[0].charAt(0))) {
            //Integer[] args1 = Arrays.stream.mapToInt(Interger::parseInt).toArray();
            Integer[] args1 = new Integer[args.length];
            for (int i = 0; i < args.length; i++)
                args1[i] = Integer.parseInt(args[i]);
            System.out.println(sol.sum(args1));
        } else
            System.out.println(sol.sum(args));


    }

    public Integer sum(Integer[] ints) {
        Integer sum = 0;
        for (int i = 0; i < ints.length; i++)
            sum += ints[i];

        return sum;

    }

    public String sum(String[] ints) {
        StringBuilder sb = new StringBuilder();
        for (String str : ints)
            sb.append(str);
        return sb.toString();
    }
}
