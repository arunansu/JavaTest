import java.util.Stack;

public class StringTest {

	public static String[] getClosing(String[] values) {
		Stack<Character> bracketStack = new Stack<Character>();
		String[] closings = new String[values.length];
		boolean hasBraces = false;
		boolean matched = true;
		int arrIndex = 0;
		
		for(String x: values) {
			for(char c : x.toCharArray()){
				if(c == '(' || c == '{' || c =='['){
					bracketStack.push(c);
					hasBraces = true;
				}
				else {
					switch(c){
					case ')':
						if(!bracketStack.isEmpty() && bracketStack.peek().charValue() == '(') {
							bracketStack.pop();
						}
						else {
							matched = false;
						}
						break;
					case '}':
						if(!bracketStack.isEmpty() && bracketStack.peek().charValue() == '{') {
							bracketStack.pop();
						}
						else {
							matched = false;
						}
						break;
					case ']':
						if(bracketStack.peek().charValue() == '[') {
							bracketStack.pop();
						}
						else {
							matched = false;
						}
						break;
					default:
						break;
							
					}
				}
			}

			if(bracketStack.isEmpty() && hasBraces && matched){
				closings[arrIndex] = "YES";
			}
			else {
				closings[arrIndex] = "NO";
			}
			bracketStack.clear();
			arrIndex++;
			matched = true;
			hasBraces = false;
		}
		return closings;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] values = new String[] {"2", "{}[]()", "{[}]", "", "{", "abh"};
		for(String x: getClosing(values)) {
			System.out.print(x + " ");
		}
	}

}
