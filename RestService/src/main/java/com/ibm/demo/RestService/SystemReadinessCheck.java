package com.ibm.demo.RestService;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@Readiness  // exposes http://<hostname>:<port>/health/ready endpoint
@ApplicationScoped
public class SystemReadinessCheck implements HealthCheck {
	  private static final String READINESS_CHECK = "Readiness Check";
	  
	  @Override
	  public HealthCheckResponse call() {
		  	if (!System.getProperty("wlp.server.name").equals("RestServiceServer")) {
		  		return HealthCheckResponse.down(READINESS_CHECK);
		  	}
		  	return HealthCheckResponse.up(READINESS_CHECK);
	  }
}