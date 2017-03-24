package global.sesoc.calendar.dao;

import java.util.List;

import global.sesoc.calendar.vo.Calendar;

public interface CalendarMapper {

	//1)���� �о����(����) 
	public List<Calendar> listCal(int month) throws Exception;
	//2)���� �����ϱ� 
	public int saveCal(Calendar calendar) throws Exception;
	//3)���� �����ϱ� 
	public int delCal(int calId) throws Exception;
}
