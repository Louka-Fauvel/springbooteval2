package edu.caensup.sio.eval2.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.caensup.sio.eval2.models.Toy;

public interface IToyDAO extends CrudRepository<Toy, Integer> {

}
