
public class BinaryAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "111 1";
		String[] sArray = s.split(" ");
		int bA = Integer.parseInt(sArray[0], 2);
		System.out.println(String.valueOf(bA));
		int bB = Integer.parseInt(sArray[1], 2);
		System.out.println(String.valueOf(bB));
		int sum = bA + bB;
		System.out.println(String.valueOf(sum));
		System.out.println(Integer.toBinaryString(sum));
	}

}
