package tn.esb.j2ee.competitionServer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import tn.esb.j2ee.competitionServer.Models.Competition;
//@Repository //generique elle accepte n'importe quel type de données y compris les données

@RepositoryRestResource //n'accepte que données rest
public interface competitionRepository extends JpaRepository<Competition,Long> {
}
