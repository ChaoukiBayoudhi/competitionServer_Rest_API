package tn.esb.j2ee.competitionServer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.esb.j2ee.competitionServer.Models.Team;

import java.time.LocalDate;
import java.util.Optional;

@RepositoryRestResource
public interface teamRepository extends JpaRepository<Team,Long> {
    //HQL ou JPQL
//    @Query("from team where name=?1 and creationDate=?2")
//    Optional<Team> findByNameAndCreationDate(String name, LocalDate creationDate);
}
