package board.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardContentController {

	@Autowired
	BoardDao dao;
	
	@GetMapping("/board/content")
	public String detail(Model model,int num,int currentPage) {
		
		model.addAttribute("num",num);
		model.addAttribute("currentPage",currentPage);
		
		BoardDto dto=dao.getdataReboard(num);
		dao.updateReadCount(num);
		
		model.addAttribute("dto", dto);
		
		return "reboard/detailpage";
	}
}
