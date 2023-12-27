package org.example.repository;

import org.example.entity.Movie;
import org.example.repository.dbConnection.DBConnection;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class MovieRepo implements Repo<Movie>{

    private final DBConnection dbConnection;

    public MovieRepo(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public Movie getById(Long id) {

        try (Session session = dbConnection.getSession(Movie.class)) {

            Query<Movie> query = session
                    .createQuery("select sup from Movie sup where id = :movieId", Movie.class)
                    .setParameter("movieId", id);

            Movie singleResult = query.getSingleResult();
            return singleResult;
        }
    }
}
