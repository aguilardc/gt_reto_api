package com.example.api.repository;

import com.example.api.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPersonaRepository extends JpaRepository<Persona, Long> {

}
