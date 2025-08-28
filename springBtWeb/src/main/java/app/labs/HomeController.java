package app.labs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.labs.ex01.TemplateService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("home")
public class HomeController {
	@Autowired
	TemplateService templateService;

	@GetMapping(value = "")
	String index(Model model) {

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d HH:mm:ss");

		String today = now.format(formatter);
		model.addAttribute("today", today);

		return "home";
	}

	@GetMapping("basic")
	String basic(HttpServletRequest request, HttpSession session, Model model) {
		model.addAttribute("str", "안녕하세요");
		model.addAttribute("msg", "<b>EL Test</b>");
		model.addAttribute("num", 3.14);

		session.setAttribute("msg", "EL Test");
		request.setAttribute("a", 10);

		model.addAttribute("list", templateService.getList());
		model.addAttribute("map", templateService.getMap());
		model.addAttribute("user", templateService.getUserAccount());
		
		return "basic/basic";
	}
}
