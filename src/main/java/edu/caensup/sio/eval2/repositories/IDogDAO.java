package edu.caensup.sio.eval2.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.caensup.sio.eval2.models.Dog;

public interface IDogDAO extends CrudRepository<Dog, Integer> {

}
