package kz.edu.nu.cs.exercise;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/items")
public class PagingService {

    private List<String> list = new CopyOnWriteArrayList<String>();

    public PagingService() {
        for (int i = 0; i < 100; i++) {
            list.add("Entry " + String.valueOf(i));
        }
    }

    @GET //edit
    public Response getMyList(@QueryParam("page") int page) {
        Gson gson = new Gson();
        String json;
        PagedHelper p = new PagedHelper();
        int k=10;





                if (page == 0) {
                    p.setPrev("undefined");
                    p.setList(list.subList(0, k));
                    p.setNext(String.valueOf(page+1));
                }else{
                p.setPrev(String.valueOf(page-1));
                p.setList(list.subList(k*page,k*(page+1)));
                p.setNext(String.valueOf(page+1));
            }





        
        json = gson.toJson(p, PagedHelper.class);
        
        return Response.ok(json).build();
    }
}
