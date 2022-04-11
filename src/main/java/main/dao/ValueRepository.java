package main.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import main.entity.User;
import main.entity.Value;

@ApplicationScoped
public class ValueRepository implements PanacheRepository<Value> {
	
	// FIND BY ID
	public Value findById(int valueId) {
		return find("valueId", valueId).firstResult();
	}
	
	// GET ALL 
		public List<Value> getAll() {
			return findAll().list();
		}

}
