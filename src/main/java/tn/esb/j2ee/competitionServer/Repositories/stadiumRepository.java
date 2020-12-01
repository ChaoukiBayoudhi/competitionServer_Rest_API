package tn.esb.j2ee.competitionServer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.esb.j2ee.competitionServer.Models.Stadium;
@RepositoryRestResource
public interface stadiumRepository extends JpaRepository<Stadium,Long> {
}
