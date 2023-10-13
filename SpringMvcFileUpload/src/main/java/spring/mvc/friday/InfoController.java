package spring.mvc.friday;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class InfoController {
	
	@Autowired
	InfoInter inter;

	@GetMapping("/info/list")
	public String totallist(Model model) {
		
		model.addAttribute("count", inter.getTotalCount());
		
		List<InfoDto> list=inter.selectInfo();
		
		model.addAttribute("list", list);
		
		return "info/infolist";
	}
	
	@GetMapping("/info/addform")
	public String form() {
		return "info/addform";
	}
	
	@PostMapping("/info/insert")
	public String insert(@ModelAttribute InfoDto dto,@RequestParam MultipartFile upload,HttpSession session) {
		
		String path=session.getServletContext().getRealPath("/resources/image/");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String photo="";
		
		if(upload.getOriginalFilename().equals(""))
			photo="no";
		else {
			String fName=upload.getOriginalFilename();
			fName=sdf.format(new Date())+"_"+fName;
			photo=fName;
			
			//업로드
			try {
				upload.transferTo(new File(path+"/"+photo));		//이미지가 실제 올라가는 메소드
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//dto의 photo에 넣기
		dto.setPhoto(photo);
		
		//insert
		inter.insertInfo(dto);
				
		return "redirect:list";
	}
	
	@GetMapping("/info/uform")
	public String uform(String num,Model model) {
		
		InfoDto dto=inter.getData(num);
		
		model.addAttribute("dto", dto);
		
		return "info/updateform";
	}
	
	@PostMapping("/info/update")
	public String update(InfoDto dto,@RequestParam MultipartFile upload,HttpSession session) {
		
		String path=session.getServletContext().getRealPath("/resources/image");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String photoname;	//dto에 담을 변수
		
		String photo2=inter.getData(dto.getNum()).getPhoto();		//수정전 사진
		
		//사진선택안할경우 null
		if(upload.getOriginalFilename().equals(""))
			photoname=null;
		else {
			photoname=upload.getOriginalFilename();
			photoname=sdf.format(new Date())+"_"+photoname;
			
			File file=new File(path+"/"+photo2);
			file.delete();
			
			//업로드
			try {
				upload.transferTo(new File(path+"/"+photoname));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//dto의 photo에 업로드한 photoname 넣어주기
		dto.setPhoto(photoname);
		
		//update
		inter.updateMyInfo(dto);
		
		
		return "redirect:list";
	}
	
	@GetMapping("/info/delete")
	public String delete(String num,HttpSession session) {
		
		String photo=inter.getData(num).getPhoto();
		
		if(!photo.equals("no")) {
			String path=session.getServletContext().getRealPath("/resources/image/");
			
			File file=new File(path+"/"+photo);
			file.delete();
		}
		
		//db삭제
		inter.deleteMyInfo(num);
		
		return "redirect:list";
	}
	
}
