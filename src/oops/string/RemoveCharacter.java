package oops.string;

public class RemoveCharacter {

	public static void main(String[] args) {
		String input = "welcome to Java";
		char removeChar = 'o';
		
		StringBuffer sf = new StringBuffer();
		
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i) != removeChar)
				sf.append(input.charAt(i));
		}
		
		System.out.println(sf.toString());
		
		System.out.println(input.replace('o', ' '));
		
		System.out.println(input.getBytes().length);
	}
}
