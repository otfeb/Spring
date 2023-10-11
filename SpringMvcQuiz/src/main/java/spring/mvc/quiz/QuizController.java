package spring.mvc.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuizController {

	@GetMapping("/ilike/movie")
	public String result1() {
		return "result1";
	}
	
	@PostMapping("/movie")
	public ModelAndView result2(@RequestParam String title) {
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("title", title);
		
		mav.setViewName("result2");
		
		return mav;
	}
}
