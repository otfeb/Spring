package board.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardWriteController {
	
	@Autowired
	BoardDao dao;

	@GetMapping("/board/writeform")
	public String write(Model model, @RequestParam Map<String, String> map) {
		
		//이 5개는 답글일 경우에만 넘어옴(새글은 x)
		String currentPage=map.get("currentPage");
		String num=map.get("num");
		String regroup=map.get("regroup");
		String restep=map.get("restep");
		String relevel=map.get("relevel");
		
		System.out.println(currentPage+","+num);
		
		//입력폼에 hidden으로 넣어준다..답글일때 대비
		//0으로 넣어야 dao에서 새글로 인식
		//폼이 답글,새글 공용이므로
		model.addAttribute("currentPage", currentPage==null?"1":currentPage);
		model.addAttribute("num", num==null?"0":num);
		model.addAttribute("regroup", regroup==null?"0":regroup);
		model.addAttribute("restep", restep==null?"0":restep);
		model.addAttribute("relevel", relevel==null?"0":relevel);
		
		return "reboard/writeform";
	}
	
	@PostMapping("/board/insert")
	public String insert(@ModelAttribute BoardDto dto, 
			@RequestParam ArrayList<MultipartFile> upload,
			HttpSession session,@RequestParam String currentPage) {
		
		//실제경로
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println(path);
		System.out.println(currentPage);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String photo="";
		
		if(upload.get(0).getOriginalFilename().equals(""))
			photo="no";
		else {
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
		
		//dto의 photo에 넣기
		dto.setPhoto(photo);
		
		//insert
		dao.insertReboard(dto);
		int num=dao.getMaxNum();
		
		return "redirect:content?num="+num+"&currentPage="+currentPage;
	}
	
	
}
