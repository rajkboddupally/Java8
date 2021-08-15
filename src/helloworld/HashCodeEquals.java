package helloworld;/* Raj Kumar Boddupally created on 7/30/2021 inside the package - helloworld */

public class HashCodeEquals {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";

        System.out.println(" s1==s2 " + s1 == s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.equals(s2));

    }
}


