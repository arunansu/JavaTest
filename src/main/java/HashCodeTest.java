import java.util.HashMap;
import java.util.Map;

public class HashCodeTest {
	private String name;
	private int age;
	private int value;
	
	public HashCodeTest(String name, int age, int value) {
		this.name = name;
		this.age = age;
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return ((name == null) ? 0 : name.hashCode()) + age + value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if ((o == null) || (o.getClass() != this.getClass())) return false;
		HashCodeTest t = (HashCodeTest) o;
		return ((name == t.name) && (age == t.age) && (value == t.value));
	}
	
	public static void main(String[] args) {
		Map<HashCodeTest, Integer> m = new HashMap<HashCodeTest, Integer>();
		HashCodeTest h = new HashCodeTest("Test", 5, 7);
		m.put(h, 1);
		h.setValue(8);
		System.out.println(m.get(h));
	}

}
