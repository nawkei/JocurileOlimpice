package md.convertit.jocOlipm.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import md.convertit.jocOlimp.domain.Atlet;
import md.convertit.jocOlimp.services.FileService;
import md.convertit.jocOlimp.services.impl.ExcellFileServiceImpl;
import md.convertit.jocOlimp.services.impl.JsonFileServiceImpl;
import md.convertit.jocOlip.util.DemoData;

public class ExcellFileServiceTest {
	final String PATH = "users.xls";
	final int TOTAL_DEMO_ATLETS = 50;
	FileService fs = new ExcellFileServiceImpl();

	private ExcellFileServiceImpl excellservice = new ExcellFileServiceImpl();
	
	
	@Test 
	public void saveAllTest() throws Exception {

		List<Atlet> atletsList = DemoData.getDemoAtlets(TOTAL_DEMO_ATLETS);
		System.out.println(atletsList);
		assertNotNull(atletsList);
		excellservice.saveAll(atletsList, PATH);
		
	}
	
	@Test
	public void readAllTest() throws Exception {
		
		
		List<Atlet> listAtlets = new ArrayList<>();
		FileInputStream inputStream = new FileInputStream(new File(PATH));
		
		Workbook workbook = new HSSFWorkbook(inputStream);
	    Sheet firstSheet = workbook.getSheetAt(0);
	    Iterator<Row> iterator = firstSheet.iterator();
	    
	    while (iterator.hasNext()) {
	        Row nextRow = iterator.next();
	        Iterator<Cell> cellIterator = nextRow.cellIterator();
	        Atlet atlets = new Atlet();
	 
	        while (cellIterator.hasNext()) {
	            Cell nextCell = cellIterator.next();
	            int columnIndex = nextCell.getColumnIndex();
	 
	            switch (columnIndex) {
	            case 1:
	                atlets.setNumeAtlet((String) getCellValue(nextCell));
	                break;
	            case 2:
	                atlets.setBirthDate((String) getCellValue(nextCell));
	                break;
	            case 3:
	                atlets.setAge(getCellValue(nextCell));
	                break;
	            }
	 
	 
	        }
	        listBooks.add(aBook);
	    }
	 
	    workbook.close();
	    inputStream.close();
	 
	    return listBooks;
	    
	    
	
}

}