package org.example.repository;


import org.example.entity.Actor;
import org.example.repository.dbConnection.DBConnection;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class ActorRepo implements Repo<Actor> {

    private final DBConnection dbConnection;

    public ActorRepo(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public Actor getById(Long id) {

        try (Session session = dbConnection.getSession(Actor.class)) {

            Query<Actor> query = session
                    .createQuery("select sup from Actor sup where id = :actorId", Actor.class)
                    .setParameter("actorId", id);

            Actor singleResult = query.getSingleResult();
            return singleResult;
        }
    }
}
