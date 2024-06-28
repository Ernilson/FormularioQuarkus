package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.FormularioEntity;

@ApplicationScoped
public class FormularioRepository implements PanacheRepository<FormularioEntity> {
}
