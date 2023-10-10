package spring.di.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ex2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext2.xml");
		
		//Myinfo생성 후 확인
		Myinfo my=(Myinfo)context.getBean("my");
		System.out.println(my.toString());
		System.out.println(my);
		
		//Person
		Person p=(Person)context.getBean("person");
		p.writeDate();

	}

}
