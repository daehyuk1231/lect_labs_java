package app.labs.ex03.di01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// 1)
//		HelloController controller = new HelloController();
		
		// 2) 생성자
//		HelloController controller = new HelloController(new HelloServiceTest());
		
		// 3) Setter
//		HelloController controller = new HelloController();
//		controller.setHelloService(new HelloService());
		
//		controller.hello("홍길동");

		// 4) Spring DI
		AbstractApplicationContext context 
		= new GenericXmlApplicationContext("classpath:config/di01/application-config.xml");
		
		// 5) 생성자
		HelloController controller = context.getBean("helloController", HelloController.class);
		controller.hello("홍길동");
		
		// 6) Setter
		HelloController controller2 = context.getBean("helloController2", HelloController.class);
		controller2.hello("홍길동");
		
		HelloController controller3 = context.getBean("helloController3", HelloController.class);
		controller3.hello("홍길동");
		
		context.close();
	}

}
