package com.example.centralizedconfigurationclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CentralizedConfigurationClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralizedConfigurationClientApplication.class, args);
	}

}

@RefreshScope
@RestController
class MessageRestController {

  @Value("${myapp.password:fall back message - Config Server is not working..please check}")
  private String message;

  @RequestMapping("/message")
  String getMessage() {
    return this.message;
  }
}
