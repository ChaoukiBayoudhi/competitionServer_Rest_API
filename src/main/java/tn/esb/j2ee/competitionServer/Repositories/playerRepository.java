package tn.esb.j2ee.competitionServer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esb.j2ee.competitionServer.Models.Player;

import java.util.List;

@Repository
public interface playerRepository extends JpaRepository<Player,Long> {
    //JPQL ou HQL
//    @Query("from player where name=?1 and tshirtNumber=?2")
//    List<Player> findByNameAndTshirtNumber(String name,int tshirtNumber);
//





    //JpaRepository est definie par spring-data
    //T save(T obj) -->insert player into table Player
    //Collection<T> findAll()
    //T findById(S id) -->retourn the object that id is specified as parameter
    //Detete(T obj)
    //...


    //List<Player> findByNameContaining(String ch);

}
