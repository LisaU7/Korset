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

	// FIND BY USERNAME - - - VERKAR INTE FUNGERA
//	public User findByName(String userName) {
//		User user = find("userName", userName).firstResult();
//		return user;
//	}

	// GET ALL
	public List<User> getAll() {
		return findAll().list();
	}

}
