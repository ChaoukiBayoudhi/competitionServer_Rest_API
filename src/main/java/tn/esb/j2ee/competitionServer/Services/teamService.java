package tn.esb.j2ee.competitionServer.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;
import tn.esb.j2ee.competitionServer.Models.Player;
import tn.esb.j2ee.competitionServer.Models.Team;
import tn.esb.j2ee.competitionServer.Repositories.teamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class teamService {

    @Autowired //effectuer le necessaire pour créer le brean responsable de teamRepository
    private teamRepository teamRepos;

    public teamService(teamRepository teamRepos) {
        this.teamRepos = teamRepos;
    }
    //Add team
    public ResponseEntity<Team> addTeam(Team t1)
    {
        try {
            Team team = teamRepos.save(t1);
            return new ResponseEntity<Team>(team, HttpStatus.CREATED);
             }catch (Exception  e)
            {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    //find Team
    public ResponseEntity<Team> getTeamById(Long id)
    {
        try {
            Optional<Team> team = teamRepos.findById(id);
            return team.map(x -> ResponseEntity.ok().body(x))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get all teams
    public ResponseEntity<List<Team>> getAllTeams()
    {
        try {
            List<Team> lstTeams = teamRepos.findAll();
            if (lstTeams.isEmpty())
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity(lstTeams, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //delete
    public ResponseEntity<?> deletePlayer(Long id)
    {
        try {
            Optional<Team> team = teamRepos.findById(id);
            if (team.isEmpty())//id erroné
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            teamRepos.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //update
    public ResponseEntity<Team> updateTeam(Long id, Team newTeam)
    {
        try {
            Optional<Team> team = teamRepos.findById(id);
            if (team.isEmpty())
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            Team t1 = team.get();//pour recuperer le team qui est dans Optional
            t1.setName(newTeam.getName());
            t1.setNbPlayers(newTeam.getNbPlayers());
            t1.setCreationDate(newTeam.getCreationDate());
            t1.setPlayers(newTeam.getPlayers());
            Team res = teamRepos.save(t1);
            return new ResponseEntity<Team>(res, HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
