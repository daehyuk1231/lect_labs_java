package app.labs.ex06.mvc02;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// HandlerMapping에게 url/controller:Method 등
	@RequestMapping(value="/")
	public String home(Model model, Locale locale) {
		
		model.addAttribute("serverTime", "서버시간");
		
		return "home";
	}
}
