package sec01_finalmodifier.EX01_FinalModifier_1;

class A {
	void abc() {
		
	}
	final void bcd() {
		
	}
}
class B1 extends A {
	void abc() {
		
	}
//	void bcd() {
//		
//	}
}
final class C { 
	int a = 3;
}
//class D extends C { }

public class FinalModifier_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C c = new C();
		System.out.println(c.a);
	}

}
