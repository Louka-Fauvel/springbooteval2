package edu.caensup.sio.eval2.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.lang.NonNull;

@Entity
public class Master {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NonNull
	private String firstname;
	@NonNull
	private String lastname;
	
	@OneToMany(mappedBy = "master", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@Fetch(FetchMode.SUBSELECT)
	private List<Dog> dogs;
	
	public Master() {
		this("", "");
	}
	
	public Master(String firstname, String lastname) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	public void acquireADog(String dogName) {
		
	}
	
	public void giveAToyTo(Toy toy, String dogName) {
		
	}

}
