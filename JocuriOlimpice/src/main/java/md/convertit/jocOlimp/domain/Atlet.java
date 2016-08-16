package md.convertit.jocOlimp.domain;

import java.util.Date;

public class Atlet {
	
	private String numeAtlet;
	private Long id;
	private Date birthDate;
	private int age;
	private TaraOrigine taraOrigine;
	private boolean hasMedals;
	public Atlet() {
		super();
	}
	public Atlet(String numeAtlet, Long id, Date birthDate, int age, TaraOrigine taraOrigine, boolean hasMedals) {
		super();
		this.numeAtlet = numeAtlet;
		this.id = id;
		this.birthDate = birthDate;
		this.age = age;
		this.taraOrigine = taraOrigine;
		this.hasMedals = hasMedals;
	}
	public String getNumeAtlet() {
		return numeAtlet;
	}
	public void setNumeAtlet(String numeAtlet) {
		this.numeAtlet = numeAtlet;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public TaraOrigine getTaraOrigine() {
		return taraOrigine;
	}
	public void setTaraOrigine(TaraOrigine taraOrigine) {
		this.taraOrigine = taraOrigine;
	}
	public boolean isHasMedals() {
		return hasMedals;
	}
	public void setHasMedals(boolean hasMedals) {
		this.hasMedals = hasMedals;
	}
	@Override
	public String toString() {
		return "Atlet [numeAtlet=" + numeAtlet + ", id=" + id + ", birthDate=" + birthDate + ", age=" + age
				+ ", taraOrigine=" + taraOrigine + ", hasMedals=" + hasMedals + "]";
	}
	
	
	
	
}
