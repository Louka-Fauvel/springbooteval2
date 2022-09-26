package edu.caensup.sio.eval2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.caensup.sio.eval2.models.Master;

@Repository
public interface IMasterDAO extends JpaRepository<Master, Integer> {

	public List<Master> findByFirstnameAndLastname(String firstname, String lastname);
	
}
