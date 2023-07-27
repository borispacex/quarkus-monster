package io.readeasy.monster.health;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
@ApplicationScoped
public class CheckCatalog implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        // Aqui escribimos el codigo necesario para hacer el test al catalogo

        return HealthCheckResponse.named("Catalogo de Vehiculos, OK")
                .up()
                .withData("Tiempo de respuesta", 5000) // opcional
                .build();
    }
}
