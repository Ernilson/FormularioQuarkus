package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.controller.mapper.FormularioMapper;
import org.acme.entity.FormularioEntity;
import org.acme.entity.dto.FormularioDTO;
import org.acme.repository.FormularioRepository;

import java.util.List;

@ApplicationScoped
public class FormularioService {

    @Inject
    private FormularioRepository repository;

    @Inject
    private FormularioMapper mapper;

    public List<FormularioDTO> findAll() {
        List<FormularioEntity> formularioEntityList = repository.findAll().list();
        return mapper.toFormularioDTOList(formularioEntityList);
    }

    public FormularioDTO crateFormulario(FormularioDTO dto){
        var entity = mapper.toFormularioEntity(dto);
        repository.persist(entity);
        return mapper.toFomularioDTO(entity);
    }

    public FormularioDTO formularioUpdate(Long id, FormularioDTO formularioDTO) {
        FormularioEntity entity = repository.findById(id);
        if (entity == null) {
            throw new IllegalArgumentException("FormularioEntity not found with id " + id);
        }
        entity.setNome(formularioDTO.getNome());
        entity.setEmail(formularioDTO.getEmail());
        entity.setEndereco(formularioDTO.getEndereco());
        entity.setTelefone(formularioDTO.getTelefone());
        entity.setIdade(formularioDTO.getIdade());

        repository.persist(entity);  // `persist` can be omitted if using Panache, as changes are automatically tracked and persisted.

        return mapper.toFomularioDTO(entity);
    }

    public void deleteFormulario(Long id){
        repository.deleteById(id);
    }
}

