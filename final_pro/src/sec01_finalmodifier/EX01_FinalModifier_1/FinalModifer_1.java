package sec01_finalmodifier.EX01_FinalModifier_1;

class A1 {
	int a = 3;
	final int b = 5;
	A1(){
		
	}
}
class A2 {
	int a;
	final int b;
	A2(){
		a = 3;
		b = 5;
	}
}

class A3{
	int a = 3;
	final int b = 5;
	A3(){
		a = 5;
	}
}
class B {
	void bcd() {
		int a = 3;
		final int b = 5;
		a = 7;
//		b = 9;
	}
}

public class FinalModifer_1 {
	public static void main(String[] args) {
		A1 a1 = new A1();
		// A1 객체 안에 있는 a 필드의 값을 7로 변경하시오.
		a1.a = 7;
		System.out.println(a1.a);
		// A1 객체 안에 있는 b 필드의 값을 9로 변경하시오.
		// a1.b = 9;  // final 필드 b는 한번 정해진 값을 변경할 수 없음
		
	}
	
}
