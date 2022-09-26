package edu.caensup.sio.eval2.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Master {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstname;
	private String lastname;
	
	@OneToMany(mappedBy = "master")
	private List<Dog> dogs;
	
	private int nbDogs;
	
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
	
	public int getNbDogs() {
		return nbDogs = this.dogs.size();
	}

	public void acquireADog(String dogName) {
		
	}
	
	public void giveAToyTo(Toy toy, String dogName) {
		
	}

}
