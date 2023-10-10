package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {

	@GetMapping("/apple/list.do")		//list뒤에 .do나 다른 확장자를 붙히던 다 호출됨
	public String result1(Model model) {
		
		model.addAttribute("myname", "윤호석");
		model.addAttribute("myage", "27");
		
		return "result1";
	}
	
	@GetMapping("/banana/insert")
	public ModelAndView banana() {
		//ModelAndView는 request에 저장하기 위한 Model과 포워드 하기위한 View를 합친 클래스
		ModelAndView mav=new ModelAndView();
		
		//request에 저장
		mav.addObject("java",88);
		mav.addObject("spring",99);
		
		//포워드할 jsp파일 지정
		mav.setViewName("result2");
		
		return mav;
	}
	
	@GetMapping("/orange/delete")
	public ModelAndView menu() {
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("sangpum", "맥북프로");
		mav.addObject("price", 800000);
		mav.addObject("color", "orange");
		
		mav.setViewName("result3");
		
		return mav;
	}
	
	@GetMapping("/shop/detail")
	public String resImage() {
		
		return "result4";
	}
	
	@GetMapping("/board/insert/data")
	public String webImage() {
		return "result5";
	}
}
