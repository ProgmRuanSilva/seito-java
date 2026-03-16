package br.com.seito.resources;

import br.com.seito.services.BeneficiarioService;
import br.com.seito.entities.Beneficiario;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/beneficiarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BeneficiarioResource {

    @Inject
    BeneficiarioService beneficiarioService;

    @GET
    public List<Beneficiario> findAll() {
        return beneficiarioService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") int id) {
        Beneficiario beneficiario = beneficiarioService.findById(id);
        if (beneficiario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(beneficiario).build();
    }

    @GET
    @Path("/programa/{idPrograma}")
    public List<Beneficiario> findByIdPrograma(@PathParam("idPrograma") int idPrograma) {
        return beneficiarioService.findByIdPrograma(idPrograma);
    }

    @GET
    @Path("/criterio/{idCriterio}")
    public List<Beneficiario> findByIdCriterio(@PathParam("idCriterio") int idCriterio) {
        return beneficiarioService.findByIdCriterio(idCriterio);
    }

    @GET
    @Path("/count")
    public int count() {
        return beneficiarioService.count();
    }

    @POST
    public Response create(Beneficiario beneficiario) {
        try {
            int id = beneficiarioService.create(beneficiario);
            return Response.status(Response.Status.CREATED)
                    .entity(beneficiario)
                    .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Beneficiario beneficiario) {
        try {
            int updated = beneficiarioService.update(id, beneficiario);
            if (updated == 0) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(beneficiario).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        int deleted = beneficiarioService.delete(id);
        if (deleted == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
