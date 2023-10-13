package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonTest2Controller {

	@GetMapping("/list2")
	public Map<String, String> list2() {
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("sang", "냉장고");
		map.put("price", "2500000");
		map.put("cnt", "80");
		
		return map;
	}
	
	@GetMapping("/list4")
	public Map<String, Object> list4(@RequestParam String name){
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("미니언즈1", "01.png"));
		list.add(new PhotoDto("미니언즈2", "02.png"));
		list.add(new PhotoDto("미니언즈3", "03.png"));
		list.add(new PhotoDto("미니언즈4", "04.png"));
		list.add(new PhotoDto("미니언즈5", "05.png"));
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", "없는메뉴");
		map.put("photo", "5.jpg");
		
		for(PhotoDto dto:list) {
			if(name.equals(dto.getName())) {
				map.put("name", dto.getName());
				map.put("photo", dto.getPhoto());
			}
		}
		
		return map;
	}
}
