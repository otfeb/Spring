package spring.mvc.friday;

import java.util.List;

public interface InfoInter {

	public int getTotalCount();
	public void insertInfo(InfoDto dto);
	public List<InfoDto> selectInfo();
	public InfoDto getData(String num);
	public void updateMyInfo(InfoDto dto);
	public void deleteMyInfo(String num);
}
