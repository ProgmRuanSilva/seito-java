package br.com.seito.resources;

import br.com.seito.services.TipoDoacaoService;
import br.com.seito.entities.TipoDoacao;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/tipos-doacao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoDoacaoResource {

    @Inject
    TipoDoacaoService tipoDoacaoService;

    @GET
    public List<TipoDoacao> findAll() {
        return tipoDoacaoService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") int id) {
        TipoDoacao tipoDoacao = tipoDoacaoService.findById(id);
        if (tipoDoacao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(tipoDoacao).build();
    }

    @GET
    @Path("/nome/{nome}")
    public List<TipoDoacao> findByNome(@PathParam("nome") String nome) {
        return tipoDoacaoService.findByNome(nome);
    }

    @GET
    @Path("/count")
    public int count() {
        return tipoDoacaoService.count();
    }

    @POST
    public Response create(TipoDoacao tipoDoacao) {
        try {
            int id = tipoDoacaoService.create(tipoDoacao);
            return Response.status(Response.Status.CREATED)
                    .entity(tipoDoacao)
                    .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, TipoDoacao tipoDoacao) {
        try {
            int updated = tipoDoacaoService.update(id, tipoDoacao);
            if (updated == 0) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(tipoDoacao).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        int deleted = tipoDoacaoService.delete(id);
        if (deleted == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
