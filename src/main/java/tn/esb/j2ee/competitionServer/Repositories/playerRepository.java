package tn.esb.j2ee.competitionServer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esb.j2ee.competitionServer.Models.Player;

import java.util.List;

@Repository
public interface playerRepository extends JpaRepository<Player,Long> {
    //JpaRepository est definie par spring-data
    //T save(T obj) -->insert player into table Player
    //Collection<T> findAll()
    //T findById(S id) -->retourn the object that id is specified as parameter
    //Detete(T obj)
    //...

    @Query("FROM Player WHERE name = ?1")
    List<Player> findByName(String name);

    //List<Player> findByNameContaining(String ch);

}
