import java.util.Stack;

public class StringTest {

	public static String[] getClosing(String[] values) {
		Stack<Character> bracketStack = new Stack<Character>();
		String[] closings = new String[values.length];
		int arrIndex = 0;
		for(String x: values) {
			System.out.println(x);
			for(char c : x.toCharArray()){
				System.out.println("Reading " + c);
				if(c == '(' || c == '{' || c =='['){
					System.out.println("Pushing " + c);
					bracketStack.push(c);
				}
				else {
					if((c == ')' && bracketStack.peek().charValue() == '(') ||
						(c == '}' && bracketStack.peek().charValue() == '{') ||
						(c == ']' && bracketStack.peek().charValue() == '[')){
							System.out.println("Popping " + c);
							bracketStack.pop();
						}
					}
				}

			if(bracketStack.isEmpty()){
				closings[arrIndex] = "YES";
			}
			else {
				closings[arrIndex] = "NO";
			}
			bracketStack.clear();
			arrIndex++;
		}
		return closings;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] values = new String[] {"2", "{}[]()", "{[}]"};
		for(String x: getClosing(values)) {
			System.out.print(x + " ");
		}
	}

}
