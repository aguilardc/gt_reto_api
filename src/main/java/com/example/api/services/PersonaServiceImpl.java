package com.example.api.services;

import com.example.api.dto.PersonaDTO;
import com.example.api.entity.Persona;
import com.example.api.mapper.PersonaMapper;
import com.example.api.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaRepository personaRepository;

    @Autowired
    private PersonaMapper personaMapper;

    public PersonaDTO create(Persona persona) {
        Persona persona1 = personaRepository.save(persona);
        return personaMapper.toDTO(persona1);
    }

    public List<PersonaDTO> read() {
        var personas = personaRepository.findAll();
        return personaMapper.toDTOList(personas);
    }

    public PersonaDTO readById(Long id) {
        Persona persona = personaRepository.findById(id).get();
        if (ObjectUtils.isEmpty(persona)) return null;
        return personaMapper.toDTO(persona);
    }

    public PersonaDTO update(Persona persona) {
        Persona persona1 = personaRepository.save(persona);
        return personaMapper.toDTO(persona1);
    }

    public Boolean delete(Long id) {
        try {
            personaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
