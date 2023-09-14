package sec02_interface.EX01_InterfaceCharacteristics;

//interface A {
// 	public static final int a = 3;
// 	public abstract void abc(); 
// 	default void bcd() {
// 		System.out.println("완성된 메서드이므로 상속받을 필요없음");
// 	}
//}
//interface B {
// 	int a = 4;
// 	void abc();   
//}
//class C implements A {
//	public void abc() {
//		System.out.println("인터페이스 A로부터 상속받음");
//		A.super.bcd();
//	}
//}

/*인터페이스를 상속한 이너클래스를 생성하여 인터페이스 객체 생성*/

interface A {
	public abstract void abc();
}
//#1. 자식클래스를 직접 생성
//class B implements A {	
//	public void abc() {
//		System.out.println("매개변수 전달");
//	}
//}
class C {
	void cde(A a) {
		a.abc();
	}
}

public class InterfaceCharacteristics {

	public static void main(String[] args) {
		C c = new C();
//		A a = new B();
//		A a = new A() {
//			public void abc() {
//			  System.out.println("매개변수 전달");
//			}
//		};
//		c.cde(a);
		c.cde(new A() {
			public void abc() {
			  System.out.println("매개변수 전달");
			}
		});
	}

}
