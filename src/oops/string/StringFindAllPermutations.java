package oops.string;

/*
public class StringFindAllPermutations {

	public static void main(String[] args) {
		String input = "ABCD";
		char[] inputArr = input.toCharArray();
		int length = input.length();
		int counter = 0;

		for (int i = 0; i < length; i++) {
			for (int j = 1; j < length ; j++) {
				for (int k = 2; k < length ; k++) {
					for (int l = 3; l < length ; l++) {
						StringBuffer sf = new StringBuffer();
						sf.append(inputArr[i]).append(inputArr[j]).append(inputArr[k]).append(inputArr[l]);
						System.out.println(sf.toString());
						counter++;
					}
				}
			}
		}

		System.out.println("Total combincations " + counter);
	}
}

*/

import java.util.HashSet;
import java.util.Set;

/**
 * Java Program to find all permutations of a String
 * 
 * @author Raj
 *
 */
public class StringFindAllPermutations {
	public static Set<String> permutationFinder(String str) {

		Set<String> perm = new HashSet<String>();

		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			perm.add("");
			return perm;
		}

		char initial = str.charAt(0);
		String rem = str.substring(1);

		Set<String> words = permutationFinder(rem);

		for (String strNew : words) {
			for (int i = 0; i <= strNew.length(); i++) {
				perm.add(charInsert(strNew, initial, i));
			}
		}

		return perm;
	}

	public static String charInsert(String str, char c, int j) {

		String head = str.substring(0, j);
		String tail = str.substring(j);

		return head + c + tail;

	}

	public static void main(String[] args) {
		// String s = "AAC";
		String s1 = "ABC";
		String s2 = "ABCD";
		// System.out.println("\nPermutations for " + s + " are: \n" +
		// permutationFinder(s));
		System.out.println("\nPermutations for " + s1 + " are: \n" + permutationFinder(s1));
		System.out.println("\nPermutations for " + s2 + " are: \n" + permutationFinder(s2));
	}
}
