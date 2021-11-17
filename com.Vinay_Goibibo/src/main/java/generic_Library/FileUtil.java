package generic_Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class FileUtil {
	/**
	 * This method is used to fetch the value of a given key from the Property File
	 * @param path  (It is the path of the Property File along with the file name ".properties" extention)
	 * @param Key   (It accepts the Key as String Argument)
	 * @return		(It returns the Value of a Particular Key)
	 */
	public String propertyFileReader(String path ,String Key){
		File abspath = new File(path);
		FileInputStream fis = null ;
		try {
			fis = new FileInputStream(abspath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(Key);
	}

	/**
	 * This method is used to read all the data from CSV file
	 * @param path (It accepts the path of the Excel file along with file name".csv" extension.)
	 * @return It returns the String data in the form of List
	 * @throws CsvException 
	 */
	public List<String[]> csvFileReader(String path) throws CsvException{
		FileReader fr = null;
		try {
			fr = new FileReader(new File(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CSVReader reader = new CSVReader(fr);
		List<String[]> allData = null;
		try {
			allData = reader.readAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allData;
	}

	/**
	 * This method is used to get the String Data from Excel 
	 * @param path (It accepts the path of the Excel file along with file name".xlsx" extension.)
	 * @param sheetName (It accepts Sheet name as a String Argument)
	 * @param rowNum	(It accepts Row Number as Integer Argument)
	 * @param cellNum	(It accepts Cell Number as Integer Argument)
	 * 				"Note: In Excel index starts from 0"
	 * @return			(It returns the String data from the Excel Sheet )
	 */
	public String readStringFromExcel(String path , String sheetName, int rowNum, int cellNum){
		File abspath = new File(path);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(abspath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String data = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}

	/**
	 * This method is used to get the boolean Data from Excel
	 * @param path (It accepts the path of the Excel file along with file name ".xlsx" extension.)
	 * @param sheetName  (It accepts Sheet name as a String Argument)
	 * @param rowNum	 (It accepts Rownum as Integer Argument)
	 * @param cellNum	 (It accepts Cell as Integer Argument)
	 * @return 			 (It returns the boolean data from Excel Sheet )
	 */
	public boolean readBooleanDataFromExcel(String path, String sheetName, int rowNum, int cellNum){
		File abspath = new File(path);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(abspath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean data = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getBooleanCellValue();
		return data;
	}

	/**
	 * This method is used to get the Date Data from Excel
	 * @param path (It accepts the Path of the Excel file along with file name with ".xlsx" extension.)
	 * @param sheetName  (It accepts Sheet Name as a String Argument)
	 * @param rowNum	 (It accepts Row Number as Integer Argument)
	 * @param cellNum	 (It accepts Cell Number as Integer Argument) 
	 * @return 			 (It returns the Date data from Excel Sheet )
	 */
	public LocalDateTime readDateDataFromExcel(String path, String sheetName, int rowNum, int cellNum){
		File abspath = new File(path);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(abspath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		LocalDateTime data = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getLocalDateTimeCellValue();
		return data;
	}

	/**
	 * This method is used to get the Numeric Data from Excel
	 * @param path (It accepts the Path of the Excel file along with the file name ".xlsx" extension.)
	 * @param sheetName  (It accepts Sheet Name as a String Argument)
	 * @param rowNum	 (It accepts Row Number as Integer Argument)
	 * @param cellNum	 (It accepts Cell Number as Integer Argument)
	 * @return 			 (It returns the double type of Numeric Value from Excel Sheet )
	 */
	public double readNumbersFromExcel(String path, String sheetName, int rowNum, int cellNum) {
		File abspath = new File(path);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(abspath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double data = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
		return data;
	}
	/**
	 * This method is used to read the Multiple data from Excel and returns the  2-dimensional Array in the form of String.
	 * @param path 		(It accepts the Path of the Excel file along with the file name with ".xlsx" extension.)
	 * @param sheetName (It accepts the Sheet Name as a String Argument)
	 * @return			(It returns the Multiple data in the form of 2D String Array)
	 */
	public String[][] readMultipleDataFromExcel(String path , String sheetName)  {
		File abspath = new File(path);  //"./resources/MMTData.xlsx"
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(abspath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook workbook = null;		
			try {
				workbook = WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		String [][] sarr = new String[rowCount][cellCount];

		for(int i=0; i<rowCount; i++) {
			for(int j=0; j<cellCount; j++) {
				sarr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return sarr;
	}
}
