package spring.anno.last;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext anno1=new ClassPathXmlApplicationContext("annoContext4.xml");
		
		JumunController jc=(JumunController)anno1.getBean("jcontroller");
		jc.insertJumun("전자렌지", 150000, "orange");
		jc.deleteJumun("3");
		jc.seleteJumun("전자렌지", 150000, "orange");
	}

}
