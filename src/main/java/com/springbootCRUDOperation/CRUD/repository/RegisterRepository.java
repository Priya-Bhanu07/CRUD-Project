package com.springbootCRUDOperation.CRUD.repository;

import com.springbootCRUDOperation.CRUD.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register, String> {
}
