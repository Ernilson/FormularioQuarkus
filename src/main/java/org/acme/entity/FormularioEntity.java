package org.acme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_formulario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormularioEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private String telefone;

    private String email;

    private String endereco;

    private Long idade;
}
