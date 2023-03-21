package com.redhat.oom;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.QueryParam;

@Path("/")
public class OOMGenerator {
    @Inject
    OOMService oomService;

    @GET
    @Path("/load")
    @Produces({ "application/json" })
    public String loadHugeDataIntoHeap(@QueryParam("count") int count, @QueryParam("objectSize") int objectSize) {
        return "{\"result\":\"" + oomService.generateOOM(count, objectSize) + "\"}";
    }
}
