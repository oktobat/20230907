package sec01_abstractclass.EX01_AbstractClass_1;

abstract class A {
	abstract void abc();
}
class B extends A {
	void abc() {
		System.out.println("방법1. 자식 클래스 생성하여 추상메서드 구현");
	}
}

public class AbstractClass_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A b = new B();
		b.abc();
		A c = new B();
		c.abc();
		
//		A a = new A();   // 추상클래스는 객체 생성 불가
		
		A a = new A() { 
			void abc() {
				System.out.println("방법2. 익명이너클래스 방법으로 객체 생성");
			}
		};
		a.abc();
		
	}

}
