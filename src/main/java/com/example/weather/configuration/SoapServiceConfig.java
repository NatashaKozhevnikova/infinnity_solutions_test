package com.example.weather.configuration;

import com.example.weather.service.WeatherSoapClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

@EnableWs
@Configuration
public class SoapServiceConfig extends WsConfigurerAdapter {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.weather.wsdl");
        return marshaller;
    }
    @Bean
    public WeatherSoapClient weatherSoapClient(Jaxb2Marshaller marshaller) {
        WeatherSoapClient client = new WeatherSoapClient();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
