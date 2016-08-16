package md.convertit.jocOlipm.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;


import org.junit.Before;
import org.junit.Test;

import md.convertit.jocOlimp.domain.Atlet;
import md.convertit.jocOlimp.services.FileService;
import md.convertit.jocOlimp.services.impl.JsonFileServiceImpl;
import md.convertit.jocOlip.util.DemoData;

public class JsonFileServiceTest {
	
	FileService fs = new JsonFileServiceImpl();
	final String PATH = "users.txt";
	final int TOTAL_DEMO_ATLETS = 50;
	
	
	@Before
	public void prepare() throws Exception{
	//metoda care se executa inaintea testelor 	
		List<Atlet> atletList = DemoData.getDemoAtlets(TOTAL_DEMO_ATLETS);
		fs.saveAll(atletList, PATH);
	}
	
	@Test
	public void saveAllTest() throws Exception {
		List<Atlet> usersList = DemoData.getDemoAtlets(TOTAL_DEMO_ATLETS);
		assertNotNull(usersList);
		fs.saveAll(usersList, PATH);
	}

	@Test
	public void readAllTest() throws Exception {
		List<Atlet> atletList = fs.readAll(PATH);
		//ferificam sa fie not null (userlist sa fie differit de null)
		assertNotNull(atletList);
		assertFalse(atletList.isEmpty()); //sa nu fie goala
		assertEquals(TOTAL_DEMO_ATLETS, atletList.size());
	}
}
