package com.example.rest.web.springboot.crud_spring_web_jpa;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


@Configuration
public class MessageSourceConfig {
    
        @Bean
        public MessageSource messageSource() {
            //Es el motor que se encarga de leer, gestionar y servir los textos de tu aplicación.
            //Sabe dónde encontrar los archivos de mensajes, cómo codificarlos y cómo manejar los casos en los que no se encuentra un mensaje específico.
            ReloadableResourceBundleMessageSource source =
                    new ReloadableResourceBundleMessageSource();
            // Indica la ubicación base de los archivos de mensajes.
            source.setBasename("classpath:messages");
            // Establece la codificación de los archivos de mensajes.
            source.setDefaultEncoding("UTF-8");
            // Si no se encuentra un mensaje, utiliza el código del mensaje como mensaje predeterminado.
            source.setUseCodeAsDefaultMessage(true);
    
            return source;
        }
}
