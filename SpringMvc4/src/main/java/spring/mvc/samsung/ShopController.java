package spring.mvc.samsung;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.data.dto.ShopDto;

@Controller
public class ShopController {

	@GetMapping("/shop/list")
	public String result3() {
		
		
		return "shop/list";
	}
	
	@GetMapping("/shop/form2")
	public String form2() {
		return "shop/shopform";
	}
	
	@PostMapping("/shop/process2")
	public String process2(@ModelAttribute ShopDto dto) {
		
		
		return "shop/shopresult";
	}
	
	@GetMapping("/shop/form3")
	public String form3() {
		return "shop/mapform";
	}
	
	@PostMapping("/shop/process3")
	public ModelAndView process3(@RequestParam Map<String, String> map) {
		ModelAndView mav=new ModelAndView();
		
		String name=map.get("name");
		String java=map.get("java");
		String spring=map.get("spring");
		String jq=map.get("jq");
		
		mav.addObject("name", name);
		mav.addObject("java", java);
		mav.addObject("spring", spring);
		mav.addObject("jq", jq);
		
		mav.setViewName("shop/mapresult");
		
		return mav;
	}
}
