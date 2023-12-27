package org.example.service;

import org.example.entity.Actor;
import org.example.repository.ActorRepo;

public class ActorService {

    private final ActorRepo actorRepo;

    public ActorService(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

    public String getActorInfoById(Long id){
        Actor actorById = actorRepo.getById(id);

        String actorInfo = new StringBuilder()
                .append("The name is ").append(actorById.getFirstName()).append("\n")
                .append("The last name is ").append(actorById.getLastName()).toString();

        return actorInfo;
    }

    public void init(){
        System.out.println("init >>>>>>");
    }

    public void destroy(){
        System.out.println("<<<<<< destroy");
    }

    public void textMeSomething(){
        System.out.println("hello i'm an ActorService by fact");
    }
}
