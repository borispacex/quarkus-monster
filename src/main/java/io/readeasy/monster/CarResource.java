package io.readeasy.monster;

import io.readeasy.monster.model.Car;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/cars")
public class CarResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Car> cars = Car.listAll();
        return Response.ok(cars).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        return Car.findByIdOptional(id)
                .map(car -> Response.ok(car).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("brand/{brand}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByBrand(@PathParam("brand") String brand) {
        List<Car> cars = Car.list("SELECT c FROM Car c WHERE c.brand = ?1 ORDER BY id DESC", brand);
        return Response.ok(cars).build();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Car car) {
        Car.persist(car);
        if (car.isPersistent()) {
            return Response.created(URI.create("/cars" + car.id)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("id") Long id) {
        boolean deleted = Car.deleteById(id);
        if (deleted) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
