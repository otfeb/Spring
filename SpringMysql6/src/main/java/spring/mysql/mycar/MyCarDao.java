package spring.mysql.mycar;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyCarDao {

	@Autowired
	SqlSession session;
	
	String namespace="spring.mysql.mycar.MyCarDao";
	
	public int getTotalCount() {
		return session.selectOne(namespace+".getTotalCount");
	}
	
	//insert
	public void insertCar(MyCarDto dto) {
		session.insert("insertOfMycar", dto);
	}
	
	//전체목록
	public List<MyCarDto> getAllCars(){
		return session.selectList("getAlllistOfMyCar");
	}
	
	//delete
	public void deleteCar(String num) {
		session.delete("deleteOfMyCar", num);
	}
}
