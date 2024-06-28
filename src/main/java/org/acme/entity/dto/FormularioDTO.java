package org.acme.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class FormularioDTO {

    private String nome;

    private String telefone;

    private String email;

    private String endereco;

    private Long idade;



}
