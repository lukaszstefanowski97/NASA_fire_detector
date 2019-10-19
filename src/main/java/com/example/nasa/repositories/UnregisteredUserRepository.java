package com.example.nasa.repositories;

import com.example.nasa.entities.UnregisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnregisteredUserRepository extends JpaRepository<UnregisteredUser, Long> {

}
