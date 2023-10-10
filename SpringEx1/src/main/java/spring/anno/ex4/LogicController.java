package spring.anno.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component	//id가 'logic'
public class LogicController {
	
	@Autowired	//자동주입
	//정확한 빈의 아이디로 주입_모호성이 있는 경우는 @Resource(name="정확한이름")
	DaoInter daoInter;
	
	public LogicController(MyDao dao) {
		this.daoInter=dao;
	}
	
	//insert
	public void insert(String str) {
		daoInter.insertData(str);
	}
	
	//delete
	public void delete(String num) {
		daoInter.deleteData(num);
	}
	
}
