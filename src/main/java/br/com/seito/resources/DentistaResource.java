package br.com.seito.resources;

import br.com.seito.services.DentistaService;
import br.com.seito.entities.Dentista;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/dentistas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DentistaResource {

    @Inject
    DentistaService dentistaService;

    @GET
    public List<Dentista> findAll() {
        return dentistaService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") int id) {
        Dentista dentista = dentistaService.findById(id);
        if (dentista == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(dentista).build();
    }

    @GET
    @Path("/especialidade/{idEspecialidade}")
    public List<Dentista> findByEspecialidade(@PathParam("idEspecialidade") int idEspecialidade) {
        return dentistaService.findByEspecialidade(idEspecialidade);
    }

    @GET
    @Path("/status/{status}")
    public List<Dentista> findByStatus(@PathParam("status") String status) {
        return dentistaService.findByStatus(status);
    }

    @GET
    @Path("/cro/{cro}")
    public List<Dentista> findByCro(@PathParam("cro") String cro) {
        return dentistaService.findByCro(cro);
    }

    @GET
    @Path("/count")
    public int count() {
        return dentistaService.count();
    }

    @POST
    public Response create(Dentista dentista) {
        try {
            int id = dentistaService.create(dentista);
            return Response.status(Response.Status.CREATED)
                    .entity(dentista)
                    .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Dentista dentista) {
        try {
            int updated = dentistaService.update(id, dentista);
            if (updated == 0) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(dentista).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        int deleted = dentistaService.delete(id);
        if (deleted == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
