package org.acme.controller.mapper;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.acme.entity.FormularioEntity;
import org.acme.entity.dto.FormularioDTO;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class FormularioMapper {

    private final ModelMapper mapper;

    @Inject
    public FormularioMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public FormularioEntity toFormularioEntity(FormularioDTO request) {
        return mapper.map(request, FormularioEntity.class);
    }

    public FormularioDTO toFomularioDTO(FormularioEntity paciente) {
        return mapper.map(paciente, FormularioDTO.class);
    }

    public List<FormularioDTO> toFormularioDTOList(List<FormularioEntity> entities) {
        return entities.stream()
                .map(this::toFomularioDTO)
                .collect(Collectors.toList());
    }
}
