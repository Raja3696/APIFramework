import java.util.Scanner;

public class ReverseAString {

	public static void main(String[] args) {
		method2();
	}

	// replace a String value
	public static void method1() {
		StringBuilder build = new StringBuilder("Tony stark will not die");
		StringBuilder strReturn = build.replace(16, 20, "");
		System.out.println(strReturn);
	}

	public static void method2() {
		System.out.println("Enter a word");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(str.trim());
		System.out.println(str.strip());
		System.out.println(str);
		String word[] = str.split("");
		for(int i =word.length-1;i>=0;i--) {
			System.out.print(word[i].strip());
		}
	}

	public static void method3() {
		// reverese a string
		String given = "AUTOMATION";
		char chars[] = given.toCharArray();
		for (int i = chars.length - 1; i >= 0; i--) {
//					System.out.print(chars[i]);

		}
	}
}
