package md.convertit.jocOlipm.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
import org.junit.Assert;
import org.junit.Test;

import md.convertit.jocOlimp.domain.Atlet;
import md.convertit.jocOlimp.services.AgeCalculator;
import md.convertit.jocOlimp.services.FileService;
import md.convertit.jocOlimp.services.impl.ExcellFileServiceImpl;
import md.convertit.jocOlimp.services.impl.JsonFileServiceImpl;
import md.convertit.jocOlip.util.DemoData;

public class ExcellFileServiceTest extends AgeCalculator {
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
			List<Atlet> atletList = fs.readAll(PATH);
			// ferificam sa fie not null (userlist sa fie differit de null)
			assertNotNull(atletList);
			assertFalse(atletList.isEmpty()); // sa nu fie goala
			assertEquals(TOTAL_DEMO_ATLETS, atletList.size());
	
}

		

	    @Test
	    public void testCalculateAge_Success() {
	        // setup
	        LocalDate birthDate = LocalDate.of(1961, 5, 17);
	        // exercise
	        int actual = AgeCalculator.calculateAge(birthDate, LocalDate.of(2016, 7, 12));
	        // assert
	        Assert.assertEquals(55, actual);
	    }
	}
	
