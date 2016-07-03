
public class BinaryGap {
	
	public static int solution(int N) {
        // write your code in Java SE 8
		int count = 0;
		int maxCount = 0;
		String binaryString = BinaryPrint(N);
		for(char c: binaryString.toCharArray()){
			if(c == '0'){
				count++;
			}
			else if(c == '1') {
				if(maxCount < count) {
					maxCount = count;
				}
				count = 0;
			}
		}
        return maxCount;
    }
	
	public static String BinaryPrint(int N) {
		int count = 0;
		int remainder;
		StringBuffer binaryString = new StringBuffer();
        if(N <= 1){
        	binaryString.append(String.valueOf(N));
        }
        else {
        	while(N > 0) {
        		remainder = N %2;
                binaryString.append(String.valueOf(remainder));
                N = N / 2;
        	}
        }
        return binaryString.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(BinaryPrint(60));
		System.out.println(solution(60));
	}

}
