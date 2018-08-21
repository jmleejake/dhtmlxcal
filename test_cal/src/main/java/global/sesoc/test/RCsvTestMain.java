package global.sesoc.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class RCsvTestMain {

	// 20171230rul.csv  20180103UL.csv
	private static final String SAMPLE_CSV_FILE_PATH = "D:\\Chemical-EDI\\doc\\20180103UL.csv";
	private static final String SAMPLE_OUT_FILE_PATH = SAMPLE_CSV_FILE_PATH + ".txt";
	private static final String DATETIME_OUT_FILE_PATH = SAMPLE_CSV_FILE_PATH + "-datetime.txt";
	
	private static final String encoding ="MS932";

    public static void main(String[] args) throws IOException {
        try (
//            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        		// japanese Windows-31J / MS932
        		BufferedReader reader = new BufferedReader(
        				new InputStreamReader(new FileInputStream(SAMPLE_CSV_FILE_PATH), encoding));
        		
        		BufferedWriter writer = new BufferedWriter(
        				new OutputStreamWriter(new FileOutputStream(SAMPLE_OUT_FILE_PATH), encoding));
        		BufferedWriter writer2 = new BufferedWriter(
        				new OutputStreamWriter(new FileOutputStream(DATETIME_OUT_FILE_PATH), encoding));
        ) {
				CsvToBean<RCsvTest> csvToBean = new CsvToBeanBuilder<RCsvTest>(reader)
                    .withType(RCsvTest.class)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<RCsvTest> iterator = csvToBean.iterator();

            while (iterator.hasNext()) {
            	RCsvTest rcsv = iterator.next();
            	
            	writer2.write(String.format("%s;%s;%s\r\n", rcsv.getOrder_no(), rcsv.getOrder_datetime(), rcsv.getProduct_name()));
            	
            	String option_content = rcsv.getProduct_option();
            	
            	System.out.println(option_content);
            	writer.write(String.format("%s\r\n", option_content));
            	
            	if(option_content.length() > 1) {
            		String[] arr = option_content.split("\n");
            		
            		HashSet<String> options = new HashSet<>();
            		for (int i=0; i<arr.length; i++) {
            			String[] data = arr[i].split(":");
            			System.out.println(data.length);
            			if (data.length > 1) {
            				// 예외적인 경우가 있어 스플릿결과의 제일 마지막 배열값을 가져올수있게 처리
            				options.add(data[data.length-1].trim());
            			} else {
            				// 또 다른 예외로 일본어 자판 컴마로 데이터가 이어져있는 경우로,
            				// 콜론이 없이 컴마로만 되어있는 경우의 처리
            				String[] comma = arr[i].split("、");
            				for (String value : comma) {
            					options.add(value.trim());
            				}
            			}
            			
            			// 일단 한번밖에 보지 못하였으나 콜론과 컴마가 섞여있는 경우의 처리
            			// 이번의 경우에는 중복되는 데이터는 눈으로 봐서 삭제처리 하는것이 나을듯함
            			if (data[0].contains("、")) {
            				String[] comma = arr[i].split("、");
            				for (String value : comma) {
            					options.add(value.trim());
            				}
            			}
            		}
            		System.out.println(String.format("final value :: %s", options));
            		writer.write(String.format("final value :: %s\r\n", options));
            		System.out.println("==========================");
            		writer.write("==========================\r\n");
            	}
            }
            writer.close();
            writer2.close();
        }
    }
}
