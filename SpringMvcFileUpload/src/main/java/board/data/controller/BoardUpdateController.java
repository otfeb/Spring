package board.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardUpdateController {
	
	@Autowired
	BoardDao dao;

	@GetMapping("/board/updatepassform")
	public ModelAndView upassform(String num,String currentPage) {
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("num", num);
		mav.addObject("currentPage", currentPage);
		
		mav.setViewName("reboard/updatepathform");
		
		return mav;
	}
	
	@PostMapping("/board/updatepass")
	public ModelAndView passform(int num,int pass,int currentPage) {
		ModelAndView mav=new ModelAndView();
		
		BoardDto dto=dao.getdataReboard(num);
		
		mav.addObject("dto", dto);
		mav.addObject("currentPage", currentPage);
		
		//비번이 맞으면 수정폼, 틀린경우 passfail로 이동
		int check=dao.getCheckPass(num, pass);
		
		if(check==1) {
			mav.setViewName("reboard/updateform");
		}
		else {
			mav.setViewName("reboard/passfail");
		}
		
		return mav;
	}
	
	@PostMapping("/board/update")
	public String updateform(@ModelAttribute BoardDto dto, 
			@RequestParam ArrayList<MultipartFile> upload,
			HttpSession session,String currentPage) {
		
			//실제경로
			String path=session.getServletContext().getRealPath("/WEB-INF/photo");
			System.out.println(path);
				
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
				
			String photo="";
				
			if(upload.get(0).getOriginalFilename().equals(""))
				photo="no";
			else {
				
				//수정전에 이전사진 지우기
				String pre_photo=dao.getdataReboard(dto.getNum()).getPhoto();
				
				String[] pre_fName=pre_photo.split(",");
				for(String f:pre_fName) {
					File file=new File(path+"/"+f);
					file.delete();
				}
				
				for(MultipartFile f:upload) {
					String fName=sdf.format(new Date())+"_"+f.getOriginalFilename();
					photo+=fName+",";
						
					try {
						f.transferTo(new File(path+"/"+fName));
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
							e.printStackTrace();
					}
				}
					
				//photo에서 마지막 콤마 제거
				photo=photo.substring(0, photo.length()-1);
			}
			
			dto.setPhoto(photo);
			dao.updateReboard(dto);

			
			return "redirect:content?num="+dto.getNum()+"&currentPage="+currentPage;
	}
}
