package br.com.seito.resources;

import br.com.seito.services.ProgramaSocialService;
import br.com.seito.entities.ProgramaSocial;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/programas-sociais")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProgramaSocialResource {

    @Inject
    ProgramaSocialService programaSocialService;

    @GET
    public List<ProgramaSocial> findAll() {
        return programaSocialService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") int id) {
        ProgramaSocial programa = programaSocialService.findById(id);
        if (programa == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(programa).build();
    }

    @GET
    @Path("/nome/{nome}")
    public List<ProgramaSocial> findByNome(@PathParam("nome") String nome) {
        return programaSocialService.findByNome(nome);
    }

    @GET
    @Path("/idade/{idade}")
    public List<ProgramaSocial> findByIdade(@PathParam("idade") int idade) {
        return programaSocialService.findByIdade(idade);
    }

    @GET
    @Path("/count")
    public int count() {
        return programaSocialService.count();
    }

    @POST
    public Response create(ProgramaSocial programaSocial) {
        try {
            int id = programaSocialService.create(programaSocial);
            return Response.status(Response.Status.CREATED)
                    .entity(programaSocial)
                    .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, ProgramaSocial programaSocial) {
        try {
            int updated = programaSocialService.update(id, programaSocial);
            if (updated == 0) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(programaSocial).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        int deleted = programaSocialService.delete(id);
        if (deleted == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
