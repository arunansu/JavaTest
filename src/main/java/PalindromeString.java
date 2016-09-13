import java.util.Scanner;

public class PalindromeString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String input = scanner.nextLine();
			if ("q".equals(input)) {
				System.out.println("Exit!");
				System.exit(0);
			}
			System.out.println("input : " + input);

			Boolean isPalindrome = true;

			if (input == null) {
				System.out.println("NO");
			} else if (input.length() < 2) {
				System.out.println("YES");
			} else {
				String inputUpper = input.toUpperCase();
				int i = 0;
				int len = inputUpper.length();
				int j = len - 1;
				while (i < j && isPalindrome) {
					char left = inputUpper.charAt(i);
					char right = inputUpper.charAt(j);
					while (i < len - 1 && !Character.isLetterOrDigit(left)) {
						i++;
						left = inputUpper.charAt(i);
					}
					while (j > 0 && !Character.isLetterOrDigit(right)) {
						j--;
						right = inputUpper.charAt(j);
					}
					if (left != right) {
						isPalindrome = false;
					}
					i++;
					j--;
					if (i >= j) {
						break;
					}
				}
				if (isPalindrome) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
}
