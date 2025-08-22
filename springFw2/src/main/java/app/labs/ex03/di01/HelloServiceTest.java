package app.labs.ex03.di01;

public class HelloServiceTest implements IHelloService {

	@Override
	public String sayHello(String name) {
		System.out.println("HelloServiceTest.sayHello() 메서드 실행");
		String message = "Hello Test~~~~ " + name;
		return message;
	}

}
