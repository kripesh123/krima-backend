package com.kripesh.krima.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kripesh.krima.model.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, Long>{
	Role findByRole(String role);
}
