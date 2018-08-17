package global.sesoc.test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class RCsvWriteTestMain {
	
	private static final String RCSV_OUT = "D:\\Chemical-EDI\\rcsvtest.csv";

	public static void main(String[] args) throws IOException {
		BufferedWriter writer = null;
		CSVWriter csvWriter = null;
		try {
			writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(RCSV_OUT), "MS932"));
			
			csvWriter = new CSVWriter(writer
					, CSVWriter.DEFAULT_SEPARATOR
					, CSVWriter.NO_QUOTE_CHARACTER
					, CSVWriter.DEFAULT_ESCAPE_CHARACTER
					, CSVWriter.DEFAULT_LINE_END);
			
			ArrayList<RCSVTest2> list = new ArrayList<>();
			
			String order_no = "277968-20171228-00002806";
			String order_status = "新規受付";
			String baggage = "145898000000";
			String delivery = "1003";
			String process_no = "P123";
			String free = "FREE";
			for (int i=0; i<10; i++) {
				RCSVTest2 vo = new RCSVTest2();
				vo.setOrder_no(order_no+i);
				vo.setOrder_status(order_status);
				vo.setBaggage_claim_no(baggage+i);
				vo.setDelivery_company(delivery+i);
				vo.setProcess_no(process_no+i);
				vo.setFree_space(free+i);
				
				list.add(vo);
			}
			
			String[] header = {"受注番号", "受注ステータス", "処理番号", "お荷物伝票番号", "配送会社", "フリー項目01"};
			
//			withHeaderDefinition(csvWriter, header, list);
			
			/**
			 * 1. VO에서 csvbindbyposition어노테이션으로 컬럼의 출력 순서를 정의
			 *   (* csvbindbyname어노테이션으로 정의하면 파일출력시 헤더가 생성된다만
			 *   그 순서가 뒤죽박죽이라 csvbindbyposition어노테이션으로 데이터 출력 순서를 정의후
			 *   헤더를 따로 정의해서 출력해주는 방법이 있으니 고놈을 선택)
			 * 
			 * 2. 해당 출력 순서에 맞게 헤더를 정의하여 writeNext 
			 * 
			 * 3. beancsv를 이용하여 데이터를 출력
			 * */
			try {
				withVODefinition(csvWriter, writer, header, list);
			} catch (CsvDataTypeMismatchException e) {
				e.printStackTrace();
			} catch (CsvRequiredFieldEmptyException e) {
				e.printStackTrace();
			}
			
		} finally {
			if (csvWriter != null) {
				csvWriter.close();
			}
			
			if (writer != null) {
				writer.close();
			}
		}
	}
	
	public static void withHeaderDefinition(
			CSVWriter csvWriter
			, String[] header
			, ArrayList<RCSVTest2> list) {
		csvWriter.writeNext(header);
		
		for (RCSVTest2 vo : list) {
			csvWriter.writeNext(
				new String[]{
						vo.getOrder_no()
						, vo.getOrder_status()
						, vo.getBaggage_claim_no()
						, vo.getDelivery_company()
						, vo.getProcess_no()
						, vo.getFree_space()
				}
			);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void withVODefinition(
			CSVWriter csvWriter
			, BufferedWriter writer
			, String[] header
			, ArrayList<RCSVTest2> list) 
					throws CsvDataTypeMismatchException
					, CsvRequiredFieldEmptyException {
		StatefulBeanToCsv<RCSVTest2> beanToCSV = new StatefulBeanToCsvBuilder(writer)
	            .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
	            .build();
		
		csvWriter.writeNext(header);
		
		beanToCSV.write(list);
	}
}
