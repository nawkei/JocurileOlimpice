package md.convertit.jocOlimp.services.impl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import md.convertit.jocOlimp.domain.Atlet;
import md.convertit.jocOlimp.services.FileService;

public class JsonFileServiceImpl implements FileService{
	
	private static final Logger log = Logger.getLogger(JsonFileServiceImpl.class.getName());
	
	private Gson gson = new Gson();
	private File file;

	public void saveAll(List<Atlet> atlet, String path) throws Exception {
		
		file = new File(path);
		FileWriter fw = new FileWriter(file);
		gson.toJson(atlet, fw);
		fw.close();
		log.info("File saved to: " + file.getAbsolutePath());
		

		
	}

	public List<Atlet> readAll(String path) throws Exception {
		
		file = new File(path);
		FileReader fr = new FileReader(file);
		Type type = new TypeToken<List<Atlet>>(){}.getType();
		List<Atlet> atlet = gson.fromJson(fr, type);
		log.info(String.format("Loaded from file %s total %d objects:", file.getAbsolutePath(),atlet.size()));
		

		return atlet;
	}

}
