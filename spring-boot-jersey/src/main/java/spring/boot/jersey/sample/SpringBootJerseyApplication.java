package spring.boot.jersey.sample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootJerseyApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringBootJerseyApplication.class).run(args);
	}
}
