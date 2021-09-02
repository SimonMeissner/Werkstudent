package com.example.demo.bewerber;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface BewerberRepository extends JpaRepository<Bewerber, Long> {

}
