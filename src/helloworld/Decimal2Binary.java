package helloworld;

public class Decimal2Binary {

	public static void main(String[] args) {
		int input = 12;
		printBinary(input);
	}

	private static void printBinary(int n) {
		int[] arr =  new int[10];
		int i=0;
		while (n != 0) {
			arr[i] = n%2; 
			n=n/2;
			i++;
		}
		for(int j=i-1;j>=0;j--)
			System.out.print(arr[j]);

	}

}
