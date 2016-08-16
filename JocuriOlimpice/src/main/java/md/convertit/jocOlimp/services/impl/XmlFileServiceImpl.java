package md.convertit.jocOlimp.services.impl;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import md.convertit.jocOlimp.domain.Atlet;
import md.convertit.jocOlimp.domain.AtletXmlHelper;
import md.convertit.jocOlimp.services.FileService;
public class XmlFileServiceImpl implements FileService {

	private static final Logger log = Logger.getLogger(JsonFileServiceImpl.class.getName());
	private static File file;

	@Override
	public void saveAll(List<Atlet> atlet, String path) throws Exception {

		// pregatim obiectul File
		file = new File(path);
		JAXBContext jaxbContext = JAXBContext.newInstance(AtletXmlHelper.class);
		// din jaxbContext obtinem Marshaler-ul
		Marshaller marshaler = jaxbContext.createMarshaller();
		// sa genereze un format frumos
		marshaler.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// pregatim un helper
		AtletXmlHelper helper = new AtletXmlHelper();
		helper.setAtletList(atlet); // setam lista de useri
		// facem marshal la obiectul helper
		marshaler.marshal(helper, file);
		log.log(Level.INFO, String.format("saved objects in file: %s", file.getAbsolutePath()));

	}

	@Override
	public List<Atlet> readAll(String path) throws Exception {
		// pregatim obiectul File
		file = new File(path);
		JAXBContext jaxbContext = JAXBContext.newInstance(AtletXmlHelper.class);
		// ne trebuie unmarshaler-ul
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		// atribuim rezultatul din unmarshaling unui obiect de tip UserXmlHelper
		AtletXmlHelper helper = (AtletXmlHelper) unmarshaller.unmarshal(file);
		log.log(Level.INFO, String.format("Return total of %d objects from %s", helper.getAtletList().size(),
				file.getAbsolutePath()));

		return helper.getAtletList();
	}

}
