package io.readeasy.monster.health;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
@ApplicationScoped
public class CheckCatalogSize implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        // Aqui implentar las pruebas de ready
        return HealthCheckResponse.named("Catalogo con los datos requeridos, OK")
                .up()
                .withData("Tiempo de respuesta a la consulta", 8000) //opcional
                .build();
    }
}
