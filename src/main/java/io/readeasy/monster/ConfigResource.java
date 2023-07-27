package io.readeasy.monster;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.print.attribute.standard.Media;

@Path("/config")
public class ConfigResource {

    @Inject
    @ConfigProperty(name = "config.message.autor", defaultValue = "Red Hat Quarkus")
    String message;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/autor")
    public String getConfigInjectProperty() {
        return message;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/provider")
    public String getMessageByConfigProvider() {
        return ConfigProvider.getConfig()
                .getOptionalValue("config.message.provider", String.class)
                .orElse("Red Hay from Provider");
    }

}
