package br.com.seito.resources;

import br.com.seito.services.DoadorService;
import br.com.seito.entities.Doador;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/doadores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoadorResource {

    @Inject
    DoadorService doadorService;

    @GET
    public List<Doador> findAll() {
        return doadorService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") int id) {
        Doador doador = doadorService.findById(id);
        if (doador == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(doador).build();
    }

    @GET
    @Path("/tipo-doacao/{idTipoDoacao}")
    public List<Doador> findByIdTipoDoacao(@PathParam("idTipoDoacao") int idTipoDoacao) {
        return doadorService.findByIdTipoDoacao(idTipoDoacao);
    }

    @GET
    @Path("/cpf-cnpj/{cpfCnpj}")
    public List<Doador> findByCpfCnpj(@PathParam("cpfCnpj") String cpfCnpj) {
        return doadorService.findByCpfCnpj(cpfCnpj);
    }

    @GET
    @Path("/count")
    public int count() {
        return doadorService.count();
    }

    @POST
    public Response create(Doador doador) {
        try {
            int id = doadorService.create(doador);
            return Response.status(Response.Status.CREATED)
                    .entity(doador)
                    .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Doador doador) {
        try {
            int updated = doadorService.update(id, doador);
            if (updated == 0) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(doador).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        int deleted = doadorService.delete(id);
        if (deleted == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
