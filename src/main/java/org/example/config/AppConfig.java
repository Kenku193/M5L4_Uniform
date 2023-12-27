package org.example.config;

import org.example.repository.ActorRepo;
import org.example.repository.MovieRepo;
import org.example.repository.dbConnection.DBConnection;
import org.example.service.ActorService;
import org.example.service.MovieService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("org.example")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public DBConnection getDataSource(){
        return new DBConnection();
    }

    @Bean
    public ActorRepo getActorRepo(){ return new ActorRepo(getDataSource());}

    @Bean
    public MovieRepo getMovieRepo(){ return new MovieRepo(getDataSource());}

    @Bean(name = {"serviceA", "serviceB"}, initMethod = "init", destroyMethod = "destroy")
   // @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ActorService getActorService(){return new ActorService(getActorRepo());}

    @Bean
    public MovieService getMovieService(){return new MovieService(getMovieRepo());}

}
