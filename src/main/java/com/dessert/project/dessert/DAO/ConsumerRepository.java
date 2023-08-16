package com.dessert.project.dessert.DAO;

import com.dessert.project.dessert.entities.Consumers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumers, Integer> {
    public Optional<Consumers> findByName(String name);

    public Optional<Consumers> findByUsername(String username);

    @Query("Select AVG(age) from Consumers")
    public double avgAge();

    @Query("SELECT COUNT(*) from Consumers where sex='male'")
    public int getAllMale();

    @Query("SELECT COUNT(*) from Consumers where sex='female'")
    public int getAllFemale();
}
