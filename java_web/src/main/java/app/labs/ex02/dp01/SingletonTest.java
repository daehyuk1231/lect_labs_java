package app.labs.ex02.dp01;

public class SingletonTest {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		singleton.showCount();
		
		Singleton singleton1 = Singleton.getInstance();
		singleton1.showCount();
		
		Singleton singleton2 = Singleton.getInstance();
		singleton2.showCount();
	}
}
