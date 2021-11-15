package co.edu.unbosque.workshop5;

import co.edu.unbosque.workshop5.services.OfficialService;
import co.edu.unbosque.workshop5.services.OwnerService;
import co.edu.unbosque.workshop5.services.UserAppService;
import co.edu.unbosque.workshop5.services.VetService;
import co.edu.unbosque.workshop5.servlet.pojo.OfficialPOJO;
import co.edu.unbosque.workshop5.servlet.pojo.OwnerPOJO;
import co.edu.unbosque.workshop5.servlet.pojo.UserAppPOJO;
import co.edu.unbosque.workshop5.servlet.pojo.VetPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Optional;

@Path("/userApp")
public class UserAppResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UserAppPOJO userApp) {
        Optional<UserAppPOJO> persistedUser = Optional.of(new UserAppService().saveUser(
                userApp.getUserName(), userApp.getPassWord(), userApp.getEmail(), userApp.getRole()));
        if (userApp.getRole().equals("owner")){
            Optional<OwnerPOJO> persistedOwner = Optional.of(new OwnerService().save(
                    userApp.getUserName(), userApp.getUsernameOw().getName(),
                    userApp.getUsernameOw().getAddress(), userApp.getUsernameOw().getNeighborhood()));
            persistedOwner.get().setUsername(userApp.getUserName());
            persistedUser.get().setUsernameOw(persistedOwner.get());
        }else if(userApp.getRole().equals("official")){
            Optional<OfficialPOJO> persistedOfficial = Optional.of(new OfficialService().create(
                    userApp.getUserName(), userApp.getUsernameOff().getName()));
            persistedOfficial.get().setUsername(userApp.getUserName());
            persistedUser.get().setUsernameOff(persistedOfficial.get());
        }else if (userApp.getRole().equals("vet")){
            Optional<VetPOJO> persistedVet = Optional.of(new VetService().save(
                    userApp.getUserName(), userApp.getUsernameVet().getName(),
                    userApp.getUsernameVet().getAddress(), userApp.getUsernameVet().getNeighborhood()));
            persistedVet.get().setUsername(userApp.getUserName());
            persistedUser.get().setUsernameVet(persistedVet.get());
        }
        if (persistedUser.isPresent()){
            return Response.status(Response.Status.CREATED)
                    .build();
        }else{
            return Response.status(404).build();
        }
    }
}