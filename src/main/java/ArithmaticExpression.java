import java.util.Stack;

public class ArithmaticExpression {

	public static double evaluate (String expression) {
		double value = 0.0;
		char[] tokens = expression.toCharArray();
		Stack<Double> values = new Stack<Double>();
		Stack<Character> ops = new Stack<Character>();
		for(int i = 0; i < tokens.length; i++){
			if(tokens[i] == ' ') {
				continue;
			}
			if((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.'){
				StringBuffer sbuf = new StringBuffer();
				while(i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || (tokens[i] == '.'))) {
					sbuf.append(tokens[i++]);
				}
				values.push(Double.parseDouble(sbuf.toString()));
				--i;
			}
			else if(tokens[i] == '('){
				ops.push(tokens[i]);
			}
			else if(tokens[i] == ')'){
				while(ops.peek() != '(') {
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				}
				ops.pop();
			}
			else if(tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/'){
				while(!ops.empty() && hasPrecedence(tokens[i], ops.peek())){
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				}
				ops.push(tokens[i]);
			}
		}
		while(!ops.empty() && values.size() >= 2){
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));
		}
		if(!values.empty())
			value = values.pop();
		return value;
	}
	
	public static boolean hasPrecedence(char op1, char op2){
		if(op2 == '(' || op2 == ')'){
			return false;
		}
		else if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')){
			return false;
		}
		else
			return true;
	}
	
	public static double applyOp(char op, double b, double a){
		switch(op){
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if(b == 0)
				throw new UnsupportedOperationException("can not devide by zero");
			return a/b;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(evaluate("10 + 2 * 6.0"));
		System.out.println(evaluate("(10 + 2.0) * 3 - (7.0 - 1.0) / 8.0"));
	}

}
