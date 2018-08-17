package global.sesoc.test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CsvWriteTestMain {

	private static final String OBJECT_LIST_SAMPLE = "D:\\Chemical-EDI\\writetest2.csv";

    public static void main(String[] args) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {

        try (
//            Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));
                 Writer writer = new BufferedWriter(
                                 new OutputStreamWriter(new FileOutputStream(OBJECT_LIST_SAMPLE), "MS932"));
                 
                 CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END);
        ) {
        	List<CSVTest> myUsers = new ArrayList<>();
        	myUsers.add(new CSVTest("Sundar Pichai ♥", "sundar.pichai@gmail.com", "+1-1111111111"));
        	myUsers.add(new CSVTest("Satya Nadella", "satya.nadella@outlook.com", "+1-1111111112"));
        	myUsers.add(new CSVTest("にほんご", "メールアドレス", "カード支払い"));
        	myUsers.add(new CSVTest("番号", "メール", "携帯"));
			
        	usingAnnotation(writer, myUsers);
//        	usingDefinition(csvWriter, myUsers);
        }
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void usingAnnotation(Writer writer, List<CSVTest> myUsers) 
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
    	StatefulBeanToCsv<CSVTest> beanToCsv = new StatefulBeanToCsvBuilder(writer)
	            .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
	            .build();

		beanToCsv.write(myUsers);
    }
    
    public static void usingDefinition(CSVWriter csvWriter, List<CSVTest> myUsers) {
    	String[] headerRecord = {"受注番号", "受注ステータス", "カード決済ステータス"};
		csvWriter.writeNext(headerRecord);
		
		
		for(CSVTest tVO : myUsers) {
		     csvWriter.writeNext(new String[]{tVO.getName(), tVO.getEmail(), tVO.getTel()});
		}
    }
}
