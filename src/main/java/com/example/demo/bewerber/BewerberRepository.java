package com.example.demo.bewerber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BewerberRepository extends JpaRepository<Bewerber, Long> {

    // SELECT * FROM student WHERE email = ?
    @Query("SELECT b FROM Bewerber b WHERE b.email = ?1")
    Optional<Bewerber> findBewerberByEmail(String email);
}
