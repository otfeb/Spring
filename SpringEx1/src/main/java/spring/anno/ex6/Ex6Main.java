package spring.anno.ex6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex6Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("annoContext4.xml");
		
		MysqlController wa=(MysqlController)app.getBean("boso");
		wa.insert("송주영");
		wa.delete("3");
		wa.select("김영환");
		
		
	}

}
