package br.com.seito.resources;

import br.com.seito.services.CriterioSelecaoService;
import br.com.seito.entities.CriterioSelecao;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/criterios-selecao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CriterioSelecaoResource {

    @Inject
    CriterioSelecaoService criterioSelecaoService;

    @GET
    public List<CriterioSelecao> findAll() {
        return criterioSelecaoService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") int id) {
        CriterioSelecao criterio = criterioSelecaoService.findById(id);
        if (criterio == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(criterio).build();
    }

    @GET
    @Path("/nome/{nome}")
    public List<CriterioSelecao> findByNome(@PathParam("nome") String nome) {
        return criterioSelecaoService.findByNome(nome);
    }

    @GET
    @Path("/count")
    public int count() {
        return criterioSelecaoService.count();
    }

    @POST
    public Response create(CriterioSelecao criterioSelecao) {
        try {
            int id = criterioSelecaoService.create(criterioSelecao);
            return Response.status(Response.Status.CREATED)
                    .entity(criterioSelecao)
                    .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, CriterioSelecao criterioSelecao) {
        try {
            int updated = criterioSelecaoService.update(id, criterioSelecao);
            if (updated == 0) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(criterioSelecao).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        int deleted = criterioSelecaoService.delete(id);
        if (deleted == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
