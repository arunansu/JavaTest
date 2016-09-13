abstract class Calculation implements ICalculation{
	protected int z;
	
	public Calculation() 
	{
		System.out.println(z);
	}
	
	public void addition(int x, int y) {
		System.out.println("From Calculation addition result is " + String.valueOf(x + y));
	}
	protected void finalize() throws Throwable {
		//destructor
	}
}

interface ICalculation {
	void subtraction(int x, int y);
}

public class OOPTest extends Calculation{
	
	public OOPTest() {
		//super();
	}
	
	public void addition(int x, int y){
		super.addition(x, y);
		//System.out.println("From OOPTest addition result is " + String.valueOf(x + y));
	}
	
	public void multiplication(int x, int y) {
		System.out.println("From OOPTest multiplication result is " + String.valueOf(x * y));
	}
	
	public void subtraction(int x, int y) {
		System.out.println("From OOPTest subtraction result is " + String.valueOf(x - y));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OOPTest t = new OOPTest();
		System.out.println(Integer.MIN_VALUE);
		t.addition(Integer.MAX_VALUE, 1);
		t.multiplication(5, 6);
		t.subtraction(6, 5);
	}

}