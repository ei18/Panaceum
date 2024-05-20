package com.riwi.panaceum.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(
    title = "Api para administración de medicamentos",
    version = "1.0",
    description = "La API Panaceum es un sistema de gestión de tratamientos médicos y pacientes"))
public class OpenApiConfig {
    
}
