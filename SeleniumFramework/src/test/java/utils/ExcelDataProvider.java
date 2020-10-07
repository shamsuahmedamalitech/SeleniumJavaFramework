package utils;

public class ExcelDataProvider {
	
	static String projectPath = System.getProperty("user.dir");

	
	public static void main(String[] args) {
		
		String excelPath = projectPath + "/excel/data.xlsx";
		testData(excelPath, "Sheet1");
		
	}
	
	public static void testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				String cellData = excel.getCellDataString(i, j);
				System.out.println(cellData + "  |  ");
			}
			System.out.println();
		}
		
	}

}
