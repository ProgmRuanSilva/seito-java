package br.com.seito.resources;

import br.com.seito.services.StatusAtendimentoService;
import br.com.seito.entities.StatusAtendimento;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/status-atendimentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StatusAtendimentoResource {

    @Inject
    StatusAtendimentoService statusAtendimentoService;

    @GET
    public List<StatusAtendimento> findAll() {
        return statusAtendimentoService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") int id) {
        StatusAtendimento status = statusAtendimentoService.findById(id);
        if (status == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(status).build();
    }

    @GET
    @Path("/nome/{nome}")
    public List<StatusAtendimento> findByNome(@PathParam("nome") String nome) {
        return statusAtendimentoService.findByNome(nome);
    }

    @GET
    @Path("/count")
    public int count() {
        return statusAtendimentoService.count();
    }

    @POST
    public Response create(StatusAtendimento statusAtendimento) {
        try {
            int id = statusAtendimentoService.create(statusAtendimento);
            return Response.status(Response.Status.CREATED)
                    .entity(statusAtendimento)
                    .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, StatusAtendimento statusAtendimento) {
        try {
            int updated = statusAtendimentoService.update(id, statusAtendimento);
            if (updated == 0) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(statusAtendimento).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        int deleted = statusAtendimentoService.delete(id);
        if (deleted == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
