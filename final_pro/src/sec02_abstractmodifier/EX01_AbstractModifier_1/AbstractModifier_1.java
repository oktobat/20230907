package sec02_abstractmodifier.EX01_AbstractModifier_1;

abstract class Animal {
//	void cry() {
//		
//	}
	abstract void cry();
}
class Cat extends Animal {
	void cry() {
		System.out.println("좋은 건물 상속해주셔서 감사합니다.");
	}
}
class Dog extends Animal {
	void cry() {
		System.out.println("건물이 조금 아쉽네요.");
	}
}

public class AbstractModifier_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal1 = new Cat();
		animal1.cry();
		
		Animal animal2 = new Dog();
		animal2.cry();
		
	}

}
