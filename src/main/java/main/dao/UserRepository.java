package main.dao;

import java.util.List;


import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

import main.entity.User;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, Integer> {

	// FIND BY ID
	public User findById(int userId) {
		return find("userId", userId).firstResult();
	}

	// GET ALL
	public List<User> getAll() {
		return findAll().list();
	}

}
