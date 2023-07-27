/*
EJERCICIO:
Agregar una clase para chequear el estado Ready del servicio, llama CheckLoadData y
cuyo resultado sea down(), retorna como mensaje de datos "El tiempo de carga excede los 30 segundos, KO"
 */

package io.readeasy.monster.health;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
@ApplicationScoped
public class CheckLoadData implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("El tiempo de carga excede los 30 segundos, KO")
                .down()
                .build();
    }
}
