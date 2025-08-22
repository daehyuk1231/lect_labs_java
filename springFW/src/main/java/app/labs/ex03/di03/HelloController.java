package app.labs.ex03.di03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

// 의존성 생성방법
@Controller
public class HelloController {
	// 1) 기본
//	@Autowired
//	private IHelloService helloService;

//	@Autowired
//	private IHelloService niceService;
	
	@Autowired
	@Qualifier("niceService")
	private IHelloService helloService;

	// 2) 생성자 이용
//	private final IHelloService helloService;
//	@Autowired
	public HelloController(IHelloService helloService) {
		this.helloService = helloService;
//		this.niceService = helloService;
	}
	
	// 3) Setter
	public HelloController() {}
//	@Autowired
	public void setHelloService(IHelloService helloService) {
		this.helloService = helloService;
//		this.niceService = helloService;
	}

	public void hello(String name) {
		System.out.println("HelloController : " + helloService.sayHello(name));
//		System.out.println("HelloController : " + niceService.sayHello(name));
	}
}
