package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.dto.FormularioDTO;
import org.acme.service.FormularioService;

import java.util.List;

@Path("/api/formulario")
public class FormularioController {

    @Inject
    private FormularioService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FormularioDTO> findAll() {
        return service.findAll();
    }

    @POST
    @Transactional
    public Response saveFormulario(FormularioDTO formularioDTO) {
        try {
            service.crateFormulario(formularioDTO);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateFormulario(@PathParam("id") Long id, FormularioDTO formularioDTO) {
        try {
            service.formularioUpdate(id, formularioDTO);
            return Response.accepted().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteFormulario(Long id) {
        try {
            service.deleteFormulario(id);
            return Response.accepted().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
