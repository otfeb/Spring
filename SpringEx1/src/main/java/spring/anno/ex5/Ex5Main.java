package spring.anno.ex5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex5Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext app=new ClassPathXmlApplicationContext("annoContext4.xml");
		
		Fruit fruit=(ThilandFruit)app.getBean("tfruit");
		fruit.writeFruitName();
		
		MyFruit myFruit=(MyFruit)app.getBean("myFruit");
		myFruit.writeFruit();
	}

}
