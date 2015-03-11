package com.github.pcm.node.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

import java.nio.file.Path;

/**
 * Created by Ye Yan on 3/11/2015.
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "com.github.pcm.db")
public class Neoj4Config extends Neo4jConfiguration {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public Neoj4Config() {
        setBasePackage("com.github.pcm.node.db");
    }

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService(@Value("${database_directory}") String path) {
        return new GraphDatabaseFactory().newEmbeddedDatabase("/tmp/graphdb");
    }

}
