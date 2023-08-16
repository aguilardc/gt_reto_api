package com.example.api.services;

import com.example.api.dto.PersonaDTO;
import com.example.api.entity.Persona;

import java.util.List;

public interface IPersonaService {
    PersonaDTO create(Persona persona);

    List<PersonaDTO> read();

    PersonaDTO readById(Long id);

    PersonaDTO update(Persona persona);

    Boolean delete(Long id);
}
