package kz.edu.nu.cs.se.hw;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/items")
public class ListItemsService {

    private List<String> list = new CopyOnWriteArrayList<String>();

    public ListItemsService() {
        for (int i = 0; i < 20; i++) {
            list.add("Entry " + String.valueOf(i));
        }
        Collections.reverse(list);
    }

    @GET
    public Response getList() { //items content ti collect info java into json
        Gson gson = new Gson();

        return Response.ok(gson.toJson(list)).build();//convert list into json and send back
    }
    @GET
    @Path("clear")
    public Response clearListItems() {
        list.clear();
        Gson gson = new Gson();

        return Response.ok(gson.toJson(list)).build();
    }
    @GET
    @Path("del/{id: [0-9]+}")
    public Response deleteItem(@PathParam("id") String id) {
        list.remove(Integer.parseInt(id));
        Gson gson = new Gson();
        return Response.ok(gson.toJson(list)).build();
    }

    @GET
    @Path("{id: [0-9]+}")
    public Response getListItem(@PathParam("id") String id) {
        int i = Integer.parseInt(id);

        return Response.ok(list.get(i)).build();
    }

    @POST
    public Response postListItem(@FormParam("newEntry") String entry) {
        list.add(0, entry);

        return Response.ok().build();
    }
}
