package com.dessert.project.dessert.DAO;

import com.dessert.project.dessert.Entities.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {

    Iterable <UserRole> findAllByUserId(int userId);
}
