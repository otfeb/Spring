package spring.mvc.munje;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.data.dto.InfoDto;

@Controller
public class InfoController {
	
	@GetMapping("/info/form")
	public String form() {
		return "info/infoForm";
	}
	
	@PostMapping("/info/result")
	public ModelAndView result(@ModelAttribute("dto") InfoDto dto) {
		ModelAndView mav=new ModelAndView();
		
		String name=dto.getName();
		String color=dto.getColor();
		String hobby=dto.getHobby();
		String language=dto.getLanguage();
		
		mav.addObject("name", name);
		mav.addObject("color", color);
		mav.addObject("hobby", hobby);
		mav.addObject("language", language);
		
		mav.setViewName("info/infoResult");
		
		return mav;
	}
}
