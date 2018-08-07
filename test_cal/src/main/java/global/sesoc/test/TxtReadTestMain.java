package global.sesoc.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TxtReadTestMain {
	
	private static final String SAMPLE_FILE_PATH = "D:\\Chemical-EDI\\amazon 注文データ.txt";

	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(SAMPLE_FILE_PATH), "MS932"));
			String line = "";
			String splitBy = "	";
			
			while ((line = reader.readLine()) != null) {
				System.out.println(String.format("\none line\n%s", line));
				String[] whatArr = line.split(splitBy);
				for (String what : whatArr) {
					System.out.println(String.format("%s", what));
				}
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}
}
