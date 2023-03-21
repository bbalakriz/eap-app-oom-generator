package org.jboss.as.quickstarts.rshelloworld;

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

    // @GET
    // @Path("/xml")
    // @Produces({ "application/xml" })
    // public String getHelloWorldXML() {
    // return "<xml><result>" + oomService.generateOOM(10) + "</result></xml>";
    // }

}
