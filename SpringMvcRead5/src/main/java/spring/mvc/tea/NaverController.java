package spring.mvc.tea;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.data.dto.ShopDto;

@Controller
@RequestMapping("/naver")
public class NaverController {
	
	@GetMapping("/form1")
	public String form1() {
		return "day1010/form1";
	}
	
	@PostMapping("/read1")
	public ModelAndView read1(@RequestParam String name,
			@RequestParam String gender,@RequestParam String addr) {
		ModelAndView model=new ModelAndView();
		
		model.addObject("name", name);
		model.addObject("gender", gender);
		model.addObject("addr", addr);
		
		model.setViewName("day1010/result1");
		
		return model;
	}
	
	@GetMapping("/form2")
	public String form2() {
		return "day1010/form2";
	}
	
	//@ModelAttribute: 폼의 데이터를 읽어서 dto에 넣고 model에 저장
	//단 model에는 ShopDto타입일 경우 shopDto라는 이름으로 저장
	//만약 다른 이름 원하면 @ModelAttribute("이름")
	
	@PostMapping("/read2")
	public String read2(@ModelAttribute ShopDto dto) {
		
		return "day1010/result2";
	}
	
	@GetMapping("/form3")
	public String form3() {
		return "day1010/form3";
	}
	
	@PostMapping("/read3")
	//폼태그의 name이 key값으로 , 입력값은 value값으로
	public ModelAndView read3(@RequestParam Map<String, String> map) {
		ModelAndView model=new ModelAndView();
		
		model.addObject("sang", map.get("sang"));
		model.addObject("color", map.get("color"));
		model.addObject("price", map.get("price"));
		model.addObject("image", map.get("image"));
		
		model.setViewName("day1010/result3");
		
		return model;
	}
	
	@GetMapping("/form4")
	public String form4() {
		return "upload/uploadForm1";
	}
	
	@PostMapping("/upload1")
	public ModelAndView read1(
			@RequestParam String title,
			@RequestParam MultipartFile photo,
			HttpSession session) {
		ModelAndView mav=new ModelAndView();
		
		//업로드할 실제경로구하기
		String path=session.getServletContext().getRealPath("/WEB-INF/image");		//실제경로
		String fileName=photo.getOriginalFilename();		//업로드된 파일명
		
		//현재날짜와 시간이용해서 파일명에 저장
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHss");
		
		if(!fileName.equals("")) {
			fileName=sdf.format(new Date())+"_"+fileName;
			
			//path에 업로드
			try {
				photo.transferTo(new File(path+"/"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			fileName="no";		//업로드안할경우
		}
		
		mav.addObject("fileName", fileName);
		mav.addObject("title", title);
		mav.addObject("path", path);
		
		mav.setViewName("upload/uploadResult1");
		
		return mav;
	}
	
	@GetMapping("/uploadform5")
	public String uploadform5() {
		return "upload/uploadForm2";
	}
	
	@PostMapping("/upload2")
	public ModelAndView read2(
			@RequestParam String title,
			@RequestParam ArrayList<MultipartFile> photo,
			HttpSession session) {
		ModelAndView mav=new ModelAndView();
		
		//업로드할 실제경로구하기
		String path=session.getServletContext().getRealPath("/WEB-INF/image");		//실제경로
		
		//현재날짜와 시간이용해서 파일명에 저장
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHss");
		
		ArrayList<String> files=new ArrayList<String>();
		
		//파일명담기
		for(MultipartFile f:photo) {
			String fileName=sdf.format(new Date())+"_"+f.getOriginalFilename();
			files.add(fileName);
			
			//path에 업로드
			try {
				f.transferTo(new File(path+"/"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		mav.addObject("files", files);
		mav.addObject("title", title);
		mav.addObject("path", path);
		
		mav.setViewName("upload/uploadResult2");
		
		return mav;
	}
}
