package tn.esb.j2ee.competitionServer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import tn.esb.j2ee.competitionServer.Models.Stadium;

import java.util.List;

@Repository
public interface stadiumRepository extends JpaRepository<Stadium,Long> {
    //HQL ou JPQL
//    @Query("from stadium where name=?1")
//    List<Stadium> findByName(String name);
//    @Query("select s.name From stadium s where s.capacity between ?1 and ?2")
//    List<Stadium> stadiumswithCapacity(int valMin,int valMax);
}
