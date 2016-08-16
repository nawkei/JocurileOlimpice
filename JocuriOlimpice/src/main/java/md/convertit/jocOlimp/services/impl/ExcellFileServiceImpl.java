package md.convertit.jocOlimp.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import md.convertit.jocOlimp.domain.Atlet;
import md.convertit.jocOlimp.services.FileService;

public class ExcellFileServiceImpl implements FileService{
	private static final Logger log = Logger.getLogger(ExcellFileServiceImpl.class.getName());

	

	@Override
	public void saveAll(List<Atlet> atlets, String path) throws Exception {

		File file = new File(path);
		
		FileOutputStream fos = new FileOutputStream(file);
		
		HSSFWorkbook workbook = new HSSFWorkbook();
	
		HSSFSheet sheet = workbook.createSheet("Pag.1");
		
		for (int i = 0; i < atlets.size(); i++) {
			
		
		
		Row row = sheet.createRow(i);
		Cell cell = row.createCell(0);
		Atlet atlet = atlets.get(i);
		cell.setCellValue(atlet.getNumeAtlet());
		Cell cell2 = row.createCell(1);
		cell2.setCellValue(atlet.getBirthDate());
		Cell cell3 = row.createCell(2);
		cell3.setCellValue(atlet.getAge());
		Cell cell4 = row.createCell(3);
		cell4.setCellValue(atlet.isHasMedals());
		
		}
		
		workbook.write(fos);
		fos.close();
		log.info("File saved to: " + file.getAbsolutePath());
		
	}

	@Override
	public List<Atlet> readAll(String path) throws Exception {
		List<Atlet> listAtlets = new ArrayList<>();
		FileInputStream inputStream = new FileInputStream(new File(path));
		
		Workbook workbook = new HSSFWorkbook(inputStream);
	    Sheet firstSheet = workbook.getSheetAt(0);
	    Iterator<Row> iterator = firstSheet.iterator();
	    
	    while (iterator.hasNext()) {
	        Row nextRow = iterator.next();
	        Iterator<Cell> cellIterator = nextRow.cellIterator();
	        Atlet atlets = new Atlet();
	 
	     System.out.println("dfaf");   
	        
	        
	        
	        while (cellIterator.hasNext()) {
	            Cell nextCell = cellIterator.next();
	            int columnIndex = nextCell.getColumnIndex();
	 
	            switch (columnIndex) {
	            case 0:
	            	System.out.println(getCellValue(nextCell));
	               atlets.setNumeAtlet((String) getCellValue(nextCell));
	                break;
	            case 1:
	                //atlets.setBirthDate((Date) getCellValue(nextCell));
	                break;
	            case 2:
	               // atlets.setAge( (int) getCellValue(nextCell));
	                break;
	                
	            case 3:
	            	atlets.setHasMedals( (boolean) getCellValue(nextCell));
	            	break;
	            }
	 
	 
	        }
	        listAtlets.add(atlets);
	    }
	 
	   // workbook.close();
	    inputStream.close();
	 
	    return listAtlets;
	}
	
	private Object getCellValue(Cell cell) {
	    switch (cell.getCellType()) {
	    case Cell.CELL_TYPE_STRING:
	        return cell.getStringCellValue();
	 
	    case Cell.CELL_TYPE_BOOLEAN:
	        return cell.getBooleanCellValue();
	 
	    case Cell.CELL_TYPE_NUMERIC:
	        return cell.getNumericCellValue();
	    }
	    return null;
	}
	
	

}
