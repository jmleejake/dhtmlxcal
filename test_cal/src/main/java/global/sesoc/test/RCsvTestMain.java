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
	private static final String SAMPLE_CSV_FILE_PATH = "D:\\Chemical-EDI\\20180103UL.csv";
	private static final String SAMPLE_OUT_FILE_PATH = "D:\\Chemical-EDI\\20180103UL-csv.txt";

    public static void main(String[] args) throws IOException {
        try (
//            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        		// japanese Windows-31J / MS932
        		BufferedReader reader = new BufferedReader(
        				new InputStreamReader(new FileInputStream(SAMPLE_CSV_FILE_PATH), "Windows-31J"));
        		
        		BufferedWriter writer = new BufferedWriter(
        				new OutputStreamWriter(new FileOutputStream(SAMPLE_OUT_FILE_PATH), "Windows-31J"));
        ) {
				CsvToBean<RCsvTest> csvToBean = new CsvToBeanBuilder<RCsvTest>(reader)
                    .withType(RCsvTest.class)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<RCsvTest> iterator = csvToBean.iterator();

            while (iterator.hasNext()) {
            	RCsvTest rcsv = iterator.next();
            	String option_content = rcsv.getProduct_option();
            	
            	System.out.println(option_content);
            	writer.write(String.format("%s\r\n", option_content));
            	
            	if(option_content.length() > 1) {
            		String[] arr = option_content.split("\n");
            		
            		HashSet<String> options = new HashSet<>();
            		for (int i=0; i<arr.length; i++) {
            			String[] data = arr[i].split(":");
        				options.add(data[1].trim());
            		}
            		System.out.println(String.format("final value :: %s", options));
            		writer.write(String.format("final value :: %s\r\n", options));
            		System.out.println("==========================");
            		writer.write("==========================\r\n");
            	}
            }
            writer.close();
        }
    }
}
