package global.sesoc.test;

public class CommonUtil {
	public static String getFormattedDate(String dateData) {
		if (dateData.contains("-")) {
			dateData = dateData.replace("-", "/");
		}
		
		if (dateData.length() == 8) {
			String year = dateData.substring(0, 4);
			String month = dateData.substring(4, 6);
			String day = dateData.substring(6, 8);
			dateData = String.format("%s/%s/%s", year, month, day);
		}
		
		return dateData;
	}
}
