package global.sesoc.test;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import global.sesoc.calendar.util.EncryptionUtil;

public class TestMain {

	/**
	 * 修正反映対象를 화면상에 나타내 처음에 0개일때는 검정색 텍스트로 했다가
	 * 한 데이터라도 수정이 발생하여 DB에 적용되야 한다면 빨간색으로 나타내 반영대상 개수를 강조한다.(?)
	 * 
	 * 치환결과를 다운로드하는 유프리아루가 어떤 형태인지 정확하게 물어본적이 없음...
	 * 
	 * 8/15 저녁은 일단 프로그램 정리
	 * 
	 * 8/16 저녁은 문서작성
	 * */
	public static void main(String[] args) {
		// 상품의 세트개수, 수량, 옵션 선택개수를 고려한 치환결과 테스트
		ArrayList<String> strList = new ArrayList<>();
//		strList.add("str1");
//		strList.add("str2");
		strList.add("str1");
//		strList.add("str3");
		strList.add("str1");
		strList.add("str4");
		strList.add("str1");
		
		HashSet<String> cntCheck = new HashSet<>();
		HashMap<String, Integer> map = new HashMap<>();
		
		for (String str : strList) {
			String trimmed = str.trim();
			if (cntCheck.add(trimmed)) {
				map.put(trimmed, 1);
			} else {
				// 이미 존재하는 옵션명의 경우 +1후 map에 저장
				int recnt = map.get(trimmed);
				map.put(trimmed, recnt+1);
			}
		}
		System.out.println(map);
		String product_name = "micho*5";
		// 상품세트수
		String[] t = product_name.split("\\*");
		int product_set_no = Integer.parseInt(t[1]);
		// 상품의 개수
		int unit_no = 2;
		Set<String> option_names = map.keySet();
		StringBuffer buf = new StringBuffer(product_name);
		buf.append(" ");
		for (String option_name : option_names) {
			// 옵션개수, 상품세트수, 상품개수를 모두 곱하여 치환결과에 반영
			buf.append(option_name + "*" + (map.get(option_name)*product_set_no*unit_no));
			if (option_names.size() > 1) {
				buf.append(", ");
			}
		}
		String last = buf.toString();
		String final_str = null;
		try {
			final_str = last.substring(0, last.lastIndexOf(","));
		} catch (StringIndexOutOfBoundsException e) {
			final_str = last;
		}
		System.out.println(final_str.trim());
		
		System.out.println("++++++++++++Encryption++++++++++++");
		System.out.println(EncryptionUtil.sha256Encrypt("12345"));
		
		try {
			EncryptionUtil cipher = new EncryptionUtil("1111222233334444");
			
			System.out.println("+++++++++aes256+++++++++");
			System.out.println("+++++++++encryption+++++++++");
			System.out.println(cipher.encrypt("blahblah"));
			System.out.println("+++++++++decryption+++++++++");
			System.out.println(cipher.decrypt("mVIvFxvZQ1vDWmc4stQMXQ=="));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		
	}
}
