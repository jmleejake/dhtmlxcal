package global.sesoc.calendar.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.calendar.vo.Calendar;

@Repository
public class CalendarDAO {
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(CalendarDAO.class); 
	//1)일정 조회하기(월별)
		public ArrayList<Calendar> listCal(int month){
			CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
			ArrayList<Calendar> result=null;
			try {
				result=mapper.listCal(month);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		//2)일정 저장
		public int saveCal(Calendar calendar){
			int result = -1;
			CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
			try {
				result=mapper.saveCal(calendar);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		//3)일정 삭제
		public int delCal(int calId){
			int result = -1;
			CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
			try {
				mapper.delCal(calId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
}
