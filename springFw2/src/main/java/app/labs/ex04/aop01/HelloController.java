package app.labs.ex04.aop01;

public class HelloController {
	IHelloService helloService;
	
	public HelloController(IHelloService helloService) {
		this.helloService = helloService;
	}
		
	public void hello(String name) {
		System.out.println("HelloController : " + this.helloService.sayHello(name));
	}
}
