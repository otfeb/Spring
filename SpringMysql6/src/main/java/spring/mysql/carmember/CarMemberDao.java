package spring.mysql.carmember;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

@Repository
public class CarMemberDao implements CarMemberInter {
	
	@Autowired
	private SqlSession session;

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("getTotalCountOfCarMember");
	}

	@Override
	public void insertCarMember(CarMemberDto dto) {
		// TODO Auto-generated method stub
		session.selectOne("insertOfCarMember", dto);
	}

	@Override
	public List<CarMemberDto> selectCarMember() {

		return session.selectList("selectAllCarMember");
	}

	@Override
	public CarMemberDto getdataCarMember(int num) {
		
		return session.selectOne("getdataCarMember", num);
	}

	@Override
	public void updateCarMember(CarMemberDto dto) {

		session.update("updateOfCarMember", dto);
		
	}

	@Override
	public void deleteCarMember(int num) {

		session.delete("deleteOfCarMember", num);
		
	}

}
