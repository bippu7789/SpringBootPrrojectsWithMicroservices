package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.TechChasers;

public interface TechChasersRepository extends JpaRepository<TechChasers, Long> {

}
