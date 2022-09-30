package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.util.Random;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class DemoApplication {

	@Bean
	public HealthIndicator devoxxHealthIndicator() {
		return () -> {
			if (new Random().nextBoolean()) {
				return Health.up().build();
			}
			else {
				return Health.down().withDetail("Boooo", 42).build();
			}
		};
	}

	@Configuration
	static class SecurityConfig extends GlobalAuthenticationConfigurerAdapter {

		@Override
		public void init(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
			authenticationManagerBuilder.inMemoryAuthentication()
					.withUser("user").password("user").roles("USER").and()
					.withUser("hero").password("hero").roles("USER", "HERO");
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
