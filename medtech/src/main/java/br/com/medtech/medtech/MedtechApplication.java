package br.com.medtech.medtech;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Medtech API", version = "1", description = "Documentação de APIs do Sistema Medtech"))
public class MedtechApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedtechApplication.class, args);
    }

}
