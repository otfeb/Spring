package board.data.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.reboard.BoardDao;

@Controller
public class BoardDeleteController {
	
	@Autowired
	BoardDao dao;

	@GetMapping("/board/deletepassform")
	public ModelAndView upassform(String num,String currentPage) {
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("num", num);
		mav.addObject("currentPage", currentPage);
		
		mav.setViewName("reboard/delpassform");
		
		return mav;
	}
	
	@PostMapping("/board/deletepass")
	public String delete(@RequestParam int num,@RequestParam int currentPage,@RequestParam int pass, HttpSession session) {
		
		int passcheck=dao.getCheckPass(num, pass);
		if(passcheck==1) {
			String path=session.getServletContext().getRealPath("/WEB-INF/photo");
			String pre_photo=dao.getdataReboard(num).getPhoto();
			
			String[] pre_fName=pre_photo.split(",");
			for(String f:pre_fName) {
				File file=new File(path+"/"+f);
				file.delete();
			}
			
			dao.deleteReboard(num);
			return "redirect:list?currentPage="+currentPage;
		}
		else {
			return "reboard/passfail";
		}
		
		
	}
}
