package tn.esb.j2ee.competitionServer.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.j2ee.competitionServer.Models.Player;
import tn.esb.j2ee.competitionServer.Models.Team;
import tn.esb.j2ee.competitionServer.Repositories.playerRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class playerService {
    @Autowired
    private playerRepository plRepos;

    public playerService(playerRepository plRepos) {
        this.plRepos = plRepos;
    }
    public Collection<Player> getAllPlayers()
    {
        return plRepos.findAll();
    }
    public ResponseEntity<Player> addPlayer(Player p1)
    {
        try {
            List<Player> lstplayers= findByNameTshirtAndTeam(p1.getName(),p1.getT_shirt_Number(),p1.getHis_team().getName());
            if(!lstplayers.isEmpty())
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            Player _Player = plRepos.save(p1);        //new Player(player.getName(), player.getBithDay(), player.getT_shirt_Number()));
            return new ResponseEntity<>(_Player, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private List<Player> findByNameTshirtAndTeam(String name, int t_shirt_number, String teamName) {
    return plRepos.findAll().stream()
            .filter(x->x.getName().equalsIgnoreCase(name)&&x.getT_shirt_Number()==t_shirt_number && x.getHis_team().getName().equalsIgnoreCase(teamName))
            .collect(Collectors.toList());
    }

    public ResponseEntity<?> getPlayerById(Long id)
    {
        Optional<Player> PlayerData = plRepos.findById(id);

        if (PlayerData.isPresent()) {
            return new ResponseEntity(PlayerData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
