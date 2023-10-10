import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.ex1.Message1;
import spring.di.ex1.Message2;
import spring.di.ex1.MessageInter;

public class Ex1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("자바?");
		MessageInter m1=new Message1();
		m1.sayHello("민수");

		MessageInter m2=new Message2();
		m2.sayHello("영희");
		
		System.out.println("스프링?");
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext1.xml");
		
		MessageInter m3=(MessageInter)context.getBean("mesBean1");
		m3.sayHello("민규");
		
		MessageInter m4=context.getBean("mesBean2", Message2.class);
		m4.sayHello("성신");
	}

}
