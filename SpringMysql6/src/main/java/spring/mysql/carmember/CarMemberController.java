package spring.mysql.carmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CarMemberController {
	
	@Autowired
	CarMemberInter inter;

	@GetMapping("/member/list")
	public String list(Model model) {
		
		//개수 가져오기
		int count=inter.getTotalCount();
		
		//전체출력
		List<CarMemberDto> list=inter.selectCarMember();
		
		//request에 저장
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		
		return "carmember/memberlist";
	}
	
	@GetMapping("/member/add")
	public String add() {
		return "carmember/addform";
	}
	
	@PostMapping("/member/write")
	public String memberInsert(CarMemberDto dto) {
		
		inter.insertCarMember(dto);
		return "redirect:list";
	}
	
	@GetMapping("/member/modify")
	public String getdatamember(Model model,int num) {
		
		CarMemberDto dto=inter.getdataCarMember(num);
		
		model.addAttribute("dto", dto);
		
		return "carmember/updateform";
	}
	
	@PostMapping("/member/update")
	public String memberupdate(CarMemberDto dto) {
		
		inter.updateCarMember(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/member/delete")
	public String memberdelete(int num) {
		
		inter.deleteCarMember(num);
		
		return "redirect:list";
	}
}
