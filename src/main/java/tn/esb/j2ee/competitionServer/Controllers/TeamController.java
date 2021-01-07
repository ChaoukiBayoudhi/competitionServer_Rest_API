package tn.esb.j2ee.competitionServer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esb.j2ee.competitionServer.Models.Team;
import tn.esb.j2ee.competitionServer.Services.teamService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins="http://localhost:4200")
public class TeamController {

    private teamService teamServ;
    @Autowired
    public TeamController(teamService teamServ) {
        this.teamServ = teamServ;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Team>> getTeams()
    {
        return teamServ.getAllTeams();
    }
    @PostMapping("/newteam")
    public ResponseEntity<Team> addTeam(@Valid @RequestBody Team t1)
    {
        return teamServ.addTeam(t1);
    }
    @GetMapping("/team/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable Long id)
    {
        return teamServ.getTeamById(id);
    }
    @DeleteMapping("/team/{id}")
    public ResponseEntity deleteTeam(@PathVariable Long id)
    {
        return teamServ.deleteTeam(id);
    }
    @PutMapping("/team/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id,@Valid @RequestBody Team t1)
    {
        return teamServ.updateTeam(id,t1);
    }
}
