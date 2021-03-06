package com.microservicedemo.accountservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${accountservice.cassandra.keyspace.name}")
    private String keyspaceName;

    @Value("${accountservice.cassandra.contact.point}")
    private String contactPoint;

    @Value("${accountservice.cassandra.port}")
    private int port;

    @Value("${accountservice.cassandra.username}")
    private String username;

    @Value("${accountservice.cassandra.password}")
    private String password;

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    protected String getContactPoints() {return contactPoint;}

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public SchemaAction getSchemaAction() {return SchemaAction.CREATE_IF_NOT_EXISTS;}

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.microservicedemo.accountservice"};
    }

    @Bean
    @Override
    public CqlSessionFactoryBean cassandraSession() {
        CqlSessionFactoryBean sessionFactory = super.cassandraSession();
        sessionFactory.setUsername(username);
        sessionFactory.setPassword(password);
        return sessionFactory;
    }
}
