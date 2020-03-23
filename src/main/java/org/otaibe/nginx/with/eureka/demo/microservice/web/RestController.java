package org.otaibe.nginx.with.eureka.demo.microservice.web;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.MessageFormat;
import java.util.UUID;

@Path("/rest")
@Getter(AccessLevel.PROTECTED)
public class RestController {

    @ConfigProperty(name = "quarkus.application.name")
    String appName;

    private String appId = UUID.randomUUID().toString();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return MessageFormat.format("application-name={0}; applicationid={1}", getAppName(), getAppId());
    }
}