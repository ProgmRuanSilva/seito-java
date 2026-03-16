package br.com.seito.resources;

import br.com.seito.services.PessoaService;
import br.com.seito.entities.Pessoa;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @Inject
    PessoaService pessoaService;

    @GET
    public List<Pessoa> findAll() {
        return pessoaService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") int id) {
        Pessoa pessoa = pessoaService.findById(id);
        if (pessoa == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(pessoa).build();
    }

    @GET
    @Path("/nome/{nome}")
    public List<Pessoa> findByNome(@PathParam("nome") String nome) {
        return pessoaService.findByNome(nome);
    }

    @GET
    @Path("/email/{email}")
    public List<Pessoa> findByEmail(@PathParam("email") String email) {
        return pessoaService.findByEmail(email);
    }

    @GET
    @Path("/count")
    public int count() {
        return pessoaService.count();
    }

    @POST
    public Response create(Pessoa pessoa) {
        try {
            int id = pessoaService.create(pessoa);
            return Response.status(Response.Status.CREATED)
                    .entity(pessoa)
                    .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Pessoa pessoa) {
        try {
            int updated = pessoaService.update(id, pessoa);
            if (updated == 0) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(pessoa).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        int deleted = pessoaService.delete(id);
        if (deleted == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
