package main.dao;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

import main.entity.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

	// FIND BY ID
	public User findById(int userId) {
		return find("userId", userId).firstResult();
	}

	// FIND BY USERNAME
	public User findByName(String userName) {
		return find("userName", userName).firstResult();
	}

	// GET ALL
	public List<User> getAll() {
		return findAll().list();
	}

}
