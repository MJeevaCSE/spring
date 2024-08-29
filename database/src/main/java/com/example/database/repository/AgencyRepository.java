package com.example.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.database.model.Agency;

public interface AgencyRepository extends JpaRepository<Agency, Long>{ 
}
