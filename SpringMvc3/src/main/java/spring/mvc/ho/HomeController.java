package spring.mvc.ho;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/")
	public String start() {
		return "start";
	}
	
	@GetMapping("/login/form")
	public String form() {
		return "form";
	}
	
	@GetMapping("/login/read")
	public String process(Model model,String myid,@RequestParam(value="mypass") String pass) {	//name이름 간단하게 변경하기 위해(requestParam은 생략가능)
		
		model.addAttribute("id", myid);
		String msg="";
		
		if(pass.equals("1234")) {
			msg="로그인 성공!";
		}
		else {
			msg="로그인 실패!";
		}
		model.addAttribute("msg", msg);
		
		return "result";
	}
}
