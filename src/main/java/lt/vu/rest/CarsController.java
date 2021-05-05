package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/cars")
public class CarsController {

    @Inject
    @Setter @Getter
    private CarService carService;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final int id) {
        try {
            Car car = carService.get(id);
            CarDTO carDTO = new CarDTO(car.getId(), car.getVin(), car.getManufacturer(),
                    car.getModel(), car.getOwner().getId());
            return Response.ok(carDTO).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(CarDTO carDTO) {
        try {
            carService.updateFromDTO(carDTO);
            return Response.ok().build();
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(CarDTO carDTO) {
        try {
            carService.saveFromDTO(carDTO);
            return Response.ok().build();
        } catch (OptimisticLockException | EntityExistsException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
