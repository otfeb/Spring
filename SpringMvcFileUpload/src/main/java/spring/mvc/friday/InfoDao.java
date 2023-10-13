package spring.mvc.friday;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InfoDao implements InfoInter {
	
	@Autowired
	SqlSession session;

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("selectTotalCountOfMyInfo");
	}

	@Override
	public void insertInfo(InfoDto dto) {
		session.insert("insertOfMyInfo",dto);
		
	}

	@Override
	public List<InfoDto> selectInfo() {
		
		return session.selectList("selectAllOfMyInfo");
	}

	@Override
	public InfoDto getData(String num) {
		// TODO Auto-generated method stub
		return session.selectOne("selectOneOfMyInfo", num);
	}

	@Override
	public void updateMyInfo(InfoDto dto) {
		session.update("updateOfMyInfo",dto);
		
	}

	@Override
	public void deleteMyInfo(String num) {
		session.delete("deleteOfMyInfo", num);
		
	}

}
