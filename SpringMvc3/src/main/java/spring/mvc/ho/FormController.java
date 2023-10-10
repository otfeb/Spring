package spring.mvc.ho;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.data.dto.FormDto;

@Controller
public class FormController {

	//myforms가 나오게 포워드할 것!
	@GetMapping("/data/myform")
	public String myform() {
		return "myforms";
	}
	
	//read1_get방식폼 전송
	@GetMapping("/data/read1")
	public ModelAndView read1(String myname,int myage,@RequestParam(value="msg",defaultValue="Happyday!") String msg) {
		ModelAndView mav=new ModelAndView();
		
		//request에 저장
		mav.addObject("name", myname);
		mav.addObject("age", myage);
		mav.addObject("msg", msg);
		
		//포워드
		mav.setViewName("process1");
		return mav;
	}
	
	@PostMapping("/data/read2")
	public ModelAndView read2(@ModelAttribute FormDto dto) {
		ModelAndView model=new ModelAndView();
		
		model.addObject("dto", dto);
		model.setViewName("process2");
		
		return model;
	}
	
	@PostMapping("/data/read3")
	public ModelAndView read3(@RequestParam Map<String, String> map) {
		ModelAndView model=new ModelAndView();
		
		String sang=map.get("sang");
		String price=map.get("price");
		
		String data=sang+"의 가격은"+price+"입니다";
		
		model.addObject("data", data);
		model.setViewName("process3");
		
		return model;
	}
	
}
