package kevat2019.Harjoitustyo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HarjoitustyoApplication extends SpringBootServletInitializer {

	@Override
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HarjoitustyoApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}
	

}

