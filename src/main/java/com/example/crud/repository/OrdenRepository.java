package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Integer> {

}
