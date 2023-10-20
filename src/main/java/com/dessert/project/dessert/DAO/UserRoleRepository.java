package com.dessert.project.dessert.DAO;

import com.dessert.project.dessert.entities.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {

    Iterable <UserRole> findAllByUserId(int userId);
}
