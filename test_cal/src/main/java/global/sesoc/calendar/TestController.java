package global.sesoc.calendar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import global.sesoc.calendar.vo.Car;

@Controller
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(value="/fileUpload", method=RequestMethod.POST)
	public String processFileUpload(MultipartFile file, HttpServletRequest req) throws IOException {
		logger.info("processFileUpload");
		logger.debug("contentType: {}", file.getContentType()); 
		logger.debug("name: {}", file.getName()); 
		logger.debug("original name: {}", file.getOriginalFilename()); 
		logger.debug("size: {}", file.getSize());
		
		/*
		BufferedReader reader = 
				new BufferedReader(
						new InputStreamReader(file.getInputStream(), "MS932"));
		
		String line;
		
		while ((line = reader.readLine()) != null) {
			logger.debug("one line : {}", line);
		}
		*/
		
		/**
		 * 8/26 아라쿠 피드백
		 * 1 치환결과화면 출력시 상품명 컬럼 수정가능으로 처리요망
		 * 2 옵션쪽이 초기화가 안됐는지 이전값이 찍히는 현상 발견
		 * 옵션처리시 콜론, 일본어컴마등으로 분기처리했는데
		 * 한가지 방식으로 통일하는것으로 처리하신다고 함 => 맨처음 메일에 첨부되었던 사양서 엑셀에 나와있던 형식대로 콜론
		 * 3 상품명에 *1 붙이는거 빼버리기
		 * 4 치환이후 다운로드시 이름에 様를 세팅하여 손이 덜 갈 수 있게 수정
		 * 5 配送会社는 무조건 1003으로 세팅 (?)
		 * 6 라쿠텐수정 어쩌구 화면 => お荷物伝票番号 수정시 곧바로 서버로 날리지말고
		 * 치환전 치환후 화면처럼 모았다가 한꺼번에 처리하는 방식으로 바꾸기
		 * 7 빠른배송(あす楽希望)컬럼에 1이 있으면 お届け日指定 컬럼에 데이터 등록일 +1해서 넣고
		 * お届け時間帯 컬럼에 午前中으로해서 넣기
		 * 8 유프리아루 업로드 형식은 csv로 처리요망
		 * 컬럼은 maybe
		 * 受注番号, 受注ステータス, 処理番号, お荷物伝票番号, 配送会社, フリー項目01
		 * 단, 업로드시 受注番号 검색하여 お荷物伝票番号를 update처리하는 로직 필요
		 * 9 csv업로드시 sql exception나는 경우 예외처리로 그 다음 row로 갈수있게 처리
		 * 단, 에러난 건들에 대해서는 화면이동후 alert출력후 파일로 다운로드하여 사후처리 할수있게
		 *   - 예외처리로직 시나리오
		 *     문제점: 가끔 주소를 영어로 입력했다거나 이름쪽에 희안한 문자가 들어가게되어 SQL Exception출력후 처리 종료됨.
		 *     1 예외처리로 catch절에서 에러건에 대한 데이터를 리스트에 add 이후 다음 row continue처리
		 *     2 모든 건수에 대해 처리후 에러리스트에 대해 세션에 담아 넘기기
		 *     3 세션으로 넘어온 리스트의 건수를 json객체로 ajax success의 결과값으로 넘기기
		 *     4 에러가 몇건 있다고 파일로 다운 받겠냐고 alert출력뒤 ok클릭
		 *     5 별도 request mapping을 따서 파일을 다운로드
		 * */
		HttpSession session = req.getSession();
		
		ArrayList<Car> carList = new ArrayList<>();
		int cnt = 0;
		
		for (int i=0; i<10; i++) {
			try {
				if (i == 2 || i==6) {
					throw new Exception();
				}
				logger.debug("{}", i);
			} catch (Exception e) {
				cnt++;
				logger.error("err cnt: {}", cnt);
				carList.add(new Car(i+"", "car"+i, "model", "price", "register_date", "update_date"));
				logger.error("{}", i);
				continue;
			}
		}
		
		session.setAttribute("errList", carList);

		// 일단 갈데없으니 아싸리 다른 페이지로 이동 테스트
		return "redirect:calHome";
	}

}
