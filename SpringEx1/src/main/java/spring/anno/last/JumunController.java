package spring.anno.last;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("jcontroller")
public class JumunController {

	@Autowired
	ShopInter shopInter;
	
	int cnt=10;
	String name="홍성경";
	
	public void insertJumun(String sang,int price,String color) {
		shopInter.insertSangpum(sang, price, color);
		System.out.println(name+"님이 "+cnt+"개를 주문함!");
	}
	
	public void deleteJumun(String num) {
		shopInter.deleteSangpum(num);
	}
	
	public void seleteJumun(String name,int price,String color) {
		shopInter.selectShop(name, price, color);
		System.out.println("주문개수: "+cnt);
	}
	
}
