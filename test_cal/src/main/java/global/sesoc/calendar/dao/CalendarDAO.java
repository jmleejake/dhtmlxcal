package global.sesoc.calendar.dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		public ArrayList<Calendar> listCal(String date){
			CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
			ArrayList<Calendar> result=null;
			try {
				result=mapper.listCal(date);
				System.out.println(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		//2)일정 저장
		public int saveCal(Calendar calendar){
			/*
			 * 무제한 반복이라고 했을때 5년을 치고 컨트롤러로 넘겼을때...
			 * 
			 * .CalendarController - 0 : day
				DEBUG: global.sesoc.calendar.CalendarController - 1 : 1
				DEBUG: global.sesoc.calendar.CalendarController - 2 : 
				DEBUG: global.sesoc.calendar.CalendarController - 3 : 
				DEBUG: global.sesoc.calendar.CalendarController - 4 : #no
				
				매월 15일로 설정할 경우
				CalendarController - start_time: 2017-04-15 00:00:00
				DEBUG: global.sesoc.calendar.CalendarController - +++++++++++++
				DEBUG: global.sesoc.calendar.CalendarController - end_time: 2022-04-05 00:05:00
				DEBUG: global.sesoc.calendar.CalendarController - 0 : month
				DEBUG: global.sesoc.calendar.CalendarController - 1 : 1
				DEBUG: global.sesoc.calendar.CalendarController - 2 : 
				DEBUG: global.sesoc.calendar.CalendarController - 3 : 
				DEBUG: global.sesoc.calendar.CalendarController - 4 : #no
			 * */
			logger.debug("vo : {}", calendar);
			
			int result = -1;
			CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
			
			if(!calendar.getRec_type().equals("")) {
				Calendar recurring = new Calendar();
				recurring.setStart_date(calendar.getStart_date());
				recurring.setEnd_date(calendar.getEnd_date());
				recurring.setContent(calendar.getContent());
				recurring.setRec_type(calendar.getRec_type());
				recurring.setText(calendar.getText());
				String[] arr_rec = recurring.getRec_type().split("_");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				
				switch (arr_rec[0]) {
					case "day":
						try {
							int check_ret = 0;
							do {
								try {
									// 최초pid세팅
									if(check_ret == 0) {
										recurring.setEvent_pid("0");
									} else if(check_ret == 1) {
										// 최초 생성후 바로 다음 row에 들어가는 이벤트에는
									    // 최초생성당시의 start_date부터 해당일의 23:59:59까지로 세팅
										recurring.setRec_type(null);
										recurring.setStart_date(recurring.getStart_date());
										String end_date = recurring.getStart_date().split(" ")[0] + " 23:59:59";
										logger.debug("end_date : {}", end_date);
										recurring.setEnd_date(end_date);
									}
									logger.debug("before insert :: {}", recurring);
									result=mapper.saveCal(recurring);
									if(result > 0) {
										if(check_ret == 0) {
											// 최초 생성한 반복 이벤트의 id를 얻어 pid로 세팅
											String latest_id = mapper.selectLatestEventNum();
											recurring.setEvent_pid(latest_id);
										} else {
											// 최초생성과 생성후 바로다음 row가 아니면,
											// 최초 start_date, end_date에 하루를 더하여 각각을 세팅 
											recurring.setStart_date(mapper.selectNextDate(recurring.getStart_date()));
											recurring.setEnd_date(mapper.selectNextDate(recurring.getEnd_date()));
										}
										
										if(dateCheck(sdf.parse(recurring.getStart_date()), sdf.parse(calendar.getEnd_date()))==0) break;
										
										check_ret++;
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							} while (dateCheck(sdf.parse(recurring.getStart_date()), sdf.parse(calendar.getEnd_date())) > 0);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						break;
	
					default:
						break;
				}
			} else {
				try {
					result=mapper.saveCal(calendar);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
		public ArrayList<Calendar> listCalYr(String date) {
			// TODO Auto-generated method stub
			return null;
		}
		
		public Calendar getEvent(String id) {
			Calendar ret = null;
			CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
			try {
				ret = mapper.selectEvent(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ret;
		}
		
		public int modifyEvent(Calendar vo) {
			int ret = 0;
			CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
			try {
				ret = mapper.updateEvent(vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ret;
		}
		
		protected int dateCheck(Date a, Date b) {
			logger.debug("dateCheck :: {} - {}",a,b);
			
			int ret = 0;
			
			if(a.compareTo(b) > 0) {
				ret = -1; //a가 b보다 느린날짜일때
			} else if(a.compareTo(b) < 0) {
				ret = 1; // a가 b보다 빠른 날짜일때
			}
			
			logger.debug("dateCheck RET == {}", ret);
			
			return ret;
		}
}
