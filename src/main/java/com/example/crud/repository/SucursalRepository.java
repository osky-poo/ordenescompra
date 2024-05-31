package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {

}
