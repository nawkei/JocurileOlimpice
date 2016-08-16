package md.convertit.jocOlimp.services;

import java.util.List;
import md.convertit.jocOlimp.domain.Atlet;

/**
 * Lista de metode de lucru cu fisierele( 1- metoda de salvare in fisier a unei
 * liste cu obiecte 2- citirea unei liste de obiecte din fisier
 *
 * @author Utilizator
 *
 */

public interface FileService {

	void saveAll(List<Atlet> atlet, String path) throws Exception;

	List<Atlet> readAll(String path) throws Exception;

}
