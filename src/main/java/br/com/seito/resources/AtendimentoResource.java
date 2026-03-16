package br.com.seito.resources;

import br.com.seito.services.AtendimentoService;
import br.com.seito.entities.Atendimento;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/atendimentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AtendimentoResource {

    @Inject
    AtendimentoService atendimentoService;

    @GET
    public List<Atendimento> findAll() {
        return atendimentoService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") int id) {
        Atendimento atendimento = atendimentoService.findById(id);
        if (atendimento == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(atendimento).build();
    }

    @GET
    @Path("/solicitante/{idPessoa}")
    public List<Atendimento> findByIdPessoaSolicitante(@PathParam("idPessoa") int idPessoa) {
        return atendimentoService.findByIdPessoaSolicitante(idPessoa);
    }

    @GET
    @Path("/dentista/{idPessoaDentista}")
    public List<Atendimento> findByIdPessoaDentista(@PathParam("idPessoaDentista") int idPessoaDentista) {
        return atendimentoService.findByIdPessoaDentista(idPessoaDentista);
    }

    @GET
    @Path("/status/{idStatus}")
    public List<Atendimento> findByIdStatus(@PathParam("idStatus") int idStatus) {
        return atendimentoService.findByIdStatus(idStatus);
    }

    @GET
    @Path("/prioridade/{prioridade}")
    public List<Atendimento> findByPrioridade(@PathParam("prioridade") String prioridade) {
        return atendimentoService.findByPrioridade(prioridade);
    }

    @GET
    @Path("/count")
    public int count() {
        return atendimentoService.count();
    }

    @POST
    public Response create(Atendimento atendimento) {
        try {
            int id = atendimentoService.create(atendimento);
            return Response.status(Response.Status.CREATED)
                    .entity(atendimento)
                    .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Atendimento atendimento) {
        try {
            int updated = atendimentoService.update(id, atendimento);
            if (updated == 0) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(atendimento).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        int deleted = atendimentoService.delete(id);
        if (deleted == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
