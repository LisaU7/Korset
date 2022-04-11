package main.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import main.dao.ValueRepository;
import main.entity.Value;

@ApplicationScoped
public class ValueService {

	@Inject
	Value value;

	@Inject
	ValueRepository valueRepository;

	// ADD VALUE
	public void addValue(Value value) {
		valueRepository.persist(value);
	}

	// GET VALUE - ID
	public Value getValue(int valueId) {
		Value value = valueRepository.findById(valueId);
		return value;
	}
	
	//DELETE VALUE
	public void deleteValue(Value value) {
		valueRepository.delete(value);
	}
	
	//GET ALL
	public List<Value> getAllValues(){
		return valueRepository.getAll();
	}

}
