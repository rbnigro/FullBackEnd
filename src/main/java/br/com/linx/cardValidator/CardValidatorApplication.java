package br.com.linx.cardValidator;

import br.com.linx.cardValidator.configuration.SpringConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = SpringConfiguration.BASE_PACKAGE)
//@EnableDiscoveryClient
public class CardValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardValidatorApplication.class, args);
	}

}
