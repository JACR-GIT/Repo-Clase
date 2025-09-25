package com.proyectojpa.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.cfg.Environment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class HibernateConfig {

    private static EntityManagerFactory entityManagerFactory;

    static {
        try {
            Properties properties = new Properties();
            properties.load(HibernateConfig.class.getClassLoader().getResourceAsStream("config.properties"));

            //Convertir a Map<String, Object> porque Persistence necesita un Map
            Map<String, Object> configDePropeties = new HashMap<>();
            for (String key : properties.stringPropertyNames()) {
                configDePropeties.put(key, properties.getProperty(key));
            }

            //Crear EntityManagerFactory programáticamente
            entityManagerFactory = Persistence.createEntityManagerFactory("AlumnoPU", configDePropeties);
            // El primer parámetro ("AlumnoPU") debe coincidir con "persistence.xml"
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Error cargando hibernate.properties");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Error inicializando Hibernate");
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
