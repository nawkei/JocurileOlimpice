package md.convertit.jocOlip.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import md.convertit.jocOlimp.domain.Atlet;
import md.convertit.jocOlimp.domain.TaraOrigine;

public class DemoData {

	public static List<Atlet> getDemoAtlets(int totalObjects) {
		List<Atlet> list = new ArrayList<Atlet>();

		TaraOrigine[] tari = TaraOrigine.values();

		Random rand = new Random();

		for (int i = 0; i < totalObjects; i++) {

			Atlet atlet = new Atlet();
		
			atlet.setNumeAtlet("nume: " + rand.nextInt());
			atlet.setBirthDate(new Date());
			atlet.setTaraOrigine(tari[rand.nextInt(tari.length)]);
			atlet.setHasMedals(rand.nextBoolean());
			list.add(atlet);
		}

		return list;

	}

}
