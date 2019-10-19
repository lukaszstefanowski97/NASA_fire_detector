package com.example.nasa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnregisteredUserRepository extends JpaRepository<UnregisteredUserRepository, Long> {

}
