package com.example.api.mapper;

import com.example.api.dto.PersonaDTO;
import com.example.api.entity.Persona;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PersonaMapper {

    public PersonaDTO toDTO(Persona persona) {
        PersonaDTO personaDTO = new PersonaDTO();
        BeanUtils.copyProperties(persona, personaDTO);
        return personaDTO;
    }

    public List<PersonaDTO> toDTOList(List<Persona> personaList) {
        return personaList.stream().map(s -> toDTO(s)).collect(Collectors.toList());
    }

    public Persona toEntity(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        BeanUtils.copyProperties(personaDTO, persona);

        return persona;
    }


}
