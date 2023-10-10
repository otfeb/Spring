package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {

	@GetMapping("/happy")
	public String happy() {
		return "quiz1";
	}
}
