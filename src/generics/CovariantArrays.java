package generics;

class Fruit {

}

class Apple extends Fruit {

}

class Jonathan extends Apple {

}

class Orange extends Fruit {

}

public class CovariantArrays {
	public static void main(String[] args) {
		Fruit[] fruit = new Apple[10];

		Fruit f = new Apple();

		fruit[0] = new Apple();
		fruit[1] = new Jonathan();
		fruit[0] = new Fruit();

		fruit[1] = new Orange();
	}
}
