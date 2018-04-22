package com.scp.util.excereadwrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class ExcelReadWriteUtil {

	
	public static void main(String[] args) throws IOException {
		readTestDataFromExcel();
	}
	
	
	public static Object[][] readTestDataFromExcel() throws IOException {
		
		/**
		 * POI  -- till 2007  (HSSF)
		 * POI-ooxml  -- 2007 and +  (XSSF)
 		 * 
		 */
		
		Object[][] udata = new Object[8][3];
		
		
		XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\XYZ\\Desktop\\Patterns\\userdata.xlsx");
		XSSFSheet sheet = workbook.getSheet("UserCredentials");
		
		Iterator<Row> rows = sheet.rowIterator();
		
		int rowCount =0;
		int cellCount=0;
		rows.next();
		while(rows.hasNext()){
			
			Row row = rows.next();
					Iterator<Cell> cells = row.cellIterator();
						while(cells.hasNext()){
							Cell cell = cells.next();
							if(cell.getCellType()==cell.CELL_TYPE_NUMERIC){
								//System.out.println("inside numeric");
								continue;
							}else{
								//System.out.print(cell.getStringCellValue());
								udata[rowCount][cellCount]=cell.getStringCellValue();
								cellCount++;
							}
							//System.out.print("--");
						}
						rowCount++;
						cellCount=0;
			
		}
		
		//System.out.println("Object ARRAY -- "+udata);
		
		
		return udata;
		
	}

	
	
	public static void generatePieChart(int pass,int fail,int skip){
			      DefaultPieDataset dataset = new DefaultPieDataset( );
			      dataset.setValue("Pass", new Double( pass ) );
			      dataset.setValue("Fail", new Double( fail ) );
			      dataset.setValue("Skip", new Double( skip ) );

			      JFreeChart chart = ChartFactory.createPieChart(
			         "SCPTestReport",   // chart title
			         dataset,          // data
			         true,             // include legend
			         true,
			         false);
			         
			      int width = 640;   /* Width of the image */
			      int height = 480;  /* Height of the image */ 
			      File pieChart = new File( "MyTestReport.jpeg" ); 
			      try {
					ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	
	
	public static void writeTestCountIntoExcel(int passCount,int skipCount,int failCount) throws IOException{
		File file = new File("C:\\Users\\XYZ\\Desktop\\Patterns\\userdata.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(1);
		XSSFRow row = sheet.createRow(2);
		Cell cell1 = row.createCell(0);
		cell1.setCellValue(passCount);
		
		Cell cell2 = row.createCell(1);
		cell2.setCellValue(failCount);

		Cell cell3 = row.createCell(2);
		cell3.setCellValue(skipCount);
		//Write the workbook in file system
	      FileOutputStream out = new FileOutputStream(file);
	      workbook.write(out);
	      out.close();
	      System.out.println("Writesheet.xlsx written successfully");
		
	}
	
	
	
	
}
