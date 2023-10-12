package spring.mysql.carmember;

import java.util.List;

public interface CarMemberInter {

	public int getTotalCount();
	
	//insert
	public void insertCarMember(CarMemberDto dto);
	//all select
	public List<CarMemberDto> selectCarMember();
	//getdata
	public CarMemberDto getdataCarMember(int num);
	//update
	public void updateCarMember(CarMemberDto dto);
	//delete
	public void deleteCarMember(int num);
}
