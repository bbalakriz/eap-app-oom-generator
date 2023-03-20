package org.jboss.as.quickstarts.rshelloworld;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class OOMGenerator {
    @Inject
    OOMService oomService;

    @GET
    @Path("/json")
    @Produces({ "application/json" })
    public String getHelloWorldJSON() {
        return "{\"result\":\"" + oomService.generateOOM(10) + "\"}";
    }

    @GET
    @Path("/xml")
    @Produces({ "application/xml" })
    public String getHelloWorldXML() {
        return "<xml><result>" + oomService.generateOOM(10) + "</result></xml>";
    }

}
