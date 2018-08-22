package global.sesoc.calendar.util;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * https://blog.kindler.io/java-encrypt/
 * 
 * http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html
 * 
 * https://commons.apache.org/proper/commons-codec/download_codec.cgi
 * 
 * ----------------------------------------------------------------------------------------
 * 윈도우10 iso생성 (라이센스여부 확인필요)
 * https://support.microsoft.com/ko-kr/help/4028192/windows-create-an-iso-file-for-windows-10
 * 
 * https://www.microsoft.com/ja-jp/software-download/windows10
 * 
 * ----------------------------------------------------------------------------------------
 * 일본-한국 송금대행업체
 * http://www.yandw.net
 * 
 * ----------------------------------------------------------------------------------------
 * 갑자기 정리하고 싶어진 여러가지 내용들
 * 면접에서 물어봤던 뭔가 얕게 알던 것들...
 * 
 * 암호화의 종류
 *   단방향
 *     해쉬알고리즘
 *       시도할때마다 항상 같은 값의 고정된 길이의 문자열로 변환시켜준다.
 *     대표: SHA256
 *     사용예: 패스워드를 확인할때 복호화가 필요하지 않으니 값이 넘어오면 암호화하여 같을때 성공처리
 *     
 *   양방향
 *     대칭
 *       대용량의 데이터에 대한 암호화를 처리할때 사용
 *       DES 3DES 
 *         Data Encyption Standard
 *       AES
 *         Advanced Encryption Standard
 *       대표: AES256
 *     
 *     비대칭
 *       전자서명등의 소용량의 데이터를 처리할때 사용
 *       대표: RSA
 *         Rivest, Shamir, Adleman의 3인이 모여 만든 알고리즘
 *       공개키public 와 개인키 private가 존재
 *       A공개키로 암호화한 내용은 B개인키로만 복호화할수있고
 *       B개인키로 암호화한 내용은 A공개키로 복호화할수있고 하는 규칙을 가지고있다
 *
 *HTTP와 HTTPS
 *  HTTP
 *    Hyper Text Transfer Protocol
 *  HTTPS
 *    Hyper Text Transfer Protocol over Secure Socket Layer (SSL인증)
 *      즉 암호화된 HTTP통신이냐 아니냐를 나타내는...
 *
 *GET POST
 *  GET
 *    post보다 빠른 전송을 할수있다
 *    querystring에 담아 데이터를 전송하는데 이는 url에 노출되므로 그 길이에 제한이 있을뿐더러 보안에 취약하다
 *  POST
 *    HTTP의 전송에는 header와 body가 있는데 post전송방식은 body에 데이터를 담아 전송한다
 *    길이에 제한이 없고 보안도 좋다
 *    
 *쿠키와 세션
 *  쿠키
 *    클라이언트의 데이터파일에 정보를 저장하므로 세션보다 빠르게 서버의요청에 응답한다
 *  세션
 *    서버에 정보를 저장한다. 단, 세션id를 클라이언트의 쿠키에 저장해두고 그 세션id를 서버에 보내 정보를 가져오므로 쿠키보다 느리다.
 *    
 *스코프
 *  page
 *    한 페이지내의 스코프
 *  request
 *    서버요청 사이클(?)의 스코프
 *    include, forward는 리퀘스트 스코프에 들어간다.
 *  session
 *    브라우저를 열고 닫는 세션주기내의 스코프
 *  application
 *    컨테이너가 구동될때 가지는 스코프 (전체적인 jsp사이드에서 사용가능)
 *    
 *spring2.5 - spring3 - spring4 변화된것들
 *  http://yellowh.tistory.com/108 spring관련용어정리 사이트
 *  2.5-3
 *    spring EL의 등장
 *  3-4
 *    jdk8대응: 람다식/ repetable annotation/ date and time api
 * */
public class EncryptionUtil {
	/**
	 * 단방향 암호화 대표 : SHA256
	 * 복호화가 없으므로 별도의 키는 존재하지 않는다.
	 * 암호화시 항상 같은결과가 떨어지기 때문에 유추하지 못하도록 복잡하면서 적당한 길이의 평문이 필요하다.
	 * @param planText 평문
	 * @return
	 */
	public static String sha256Encrypt(String planText) {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(planText.getBytes());
            byte byteData[] = md.digest();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            StringBuffer hexString = new StringBuffer();
            for (int i=0;i<byteData.length;i++) {
                String hex=Integer.toHexString(0xff & byteData[i]);
                if(hex.length()==1){
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
	
	private String iv;
    private Key keySpec;
    
    /**
     * 16자리의 키값을 입력하여 객체를 생성한다.
     * @param key 암/복호화를 위한 키값
     * @throws UnsupportedEncodingException 키값의 길이가 16이하일 경우 발생
     */
	public EncryptionUtil(String key) throws UnsupportedEncodingException {
		this.iv = key.substring(0, 16);
        byte[] keyBytes = new byte[16];
        byte[] b = key.getBytes("UTF-8");
        int len = b.length;
        if(len > keyBytes.length){
            len = keyBytes.length;
        }
        System.arraycopy(b, 0, keyBytes, 0, len);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

        this.keySpec = keySpec;
	}
	
	/**
     * AES256 으로 암호화 한다.
     * @param str 암호화할 문자열
     * @return
     * @throws NoSuchAlgorithmException
     * @throws GeneralSecurityException
     * @throws UnsupportedEncodingException
     */
    public String encrypt(String str) throws NoSuchAlgorithmException, GeneralSecurityException, UnsupportedEncodingException{
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
        String enStr = new String(Base64.encodeBase64(encrypted));
        return enStr;
    }

    /**
     * AES256으로 암호화된 txt 를 복호화한다.
     * @param str 복호화할 문자열
     * @return
     * @throws NoSuchAlgorithmException
     * @throws GeneralSecurityException
     * @throws UnsupportedEncodingException
     */
    public String decrypt(String str) throws NoSuchAlgorithmException, GeneralSecurityException, UnsupportedEncodingException {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
        byte[] byteStr = Base64.decodeBase64(str.getBytes());
        return new String(c.doFinal(byteStr), "UTF-8");
    }
}
