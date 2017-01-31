abstract class Calculation implements ICalculation{
	protected int z;
	
	public Calculation() 
	{
		System.out.println("Initial value of z: " + String.valueOf(z));
	}
	
	public void addition(int x, int y) {
		System.out.println("From Calculation " + String.valueOf(x) + " + " + String.valueOf(y) + " = "  + String.valueOf(x + y));
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
		System.out.println("Derived class value of z: " + String.valueOf(z));
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
		System.out.println("Float Max Value: " + String.valueOf(Float.MAX_VALUE));
		System.out.println("Float Max Exponent Value: " + String.valueOf(Float.MAX_EXPONENT));
		System.out.println("Float Min Value: " + String.valueOf(Float.MIN_VALUE));
		System.out.println("Float Min Normal Value: " + String.valueOf(Float.MIN_NORMAL));
		System.out.println("Float Min Exponent Value: " + String.valueOf(Float.MIN_EXPONENT));
		System.out.println("Double Max Value: " + String.valueOf(Double.MAX_VALUE));
		System.out.println("Double Max Exponent Value: " + String.valueOf(Double.MAX_EXPONENT));
		System.out.println("Double Min Value: " + String.valueOf(Double.MIN_VALUE));
		System.out.println("Double Min Normal Value: " + String.valueOf(Double.MIN_NORMAL));
		System.out.println("Double Min Exponent Value: " + String.valueOf(Double.MIN_EXPONENT));
		System.out.println("Integer.MIN_VALUE: " + String.valueOf(Integer.MIN_VALUE));
		t.addition(Integer.MAX_VALUE, 1);
		t.multiplication(5, 6);
		t.subtraction(6, 5);
	}

}
