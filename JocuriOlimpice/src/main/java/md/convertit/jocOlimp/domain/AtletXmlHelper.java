package md.convertit.jocOlimp.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class AtletXmlHelper {


	private List<Atlet> atletList;

	public List<Atlet> getAtletList() {
		return atletList;
	}

	@XmlElement
	public void setAtletList(List<Atlet> atletList) {
		this.atletList = atletList;
	}

	
	

}
