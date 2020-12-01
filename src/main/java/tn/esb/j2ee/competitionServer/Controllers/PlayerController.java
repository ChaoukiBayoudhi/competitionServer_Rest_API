package tn.esb.j2ee.competitionServer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esb.j2ee.competitionServer.Models.Player;
import tn.esb.j2ee.competitionServer.Repositories.playerRepository;
import tn.esb.j2ee.competitionServer.Services.playerService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController //utilise le protocole http(Get, Post, Delete, Put,...)
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private playerService plService;

    public PlayerController(playerService plService) {
        this.plService = plService;
    }

//    @GetMapping("/all")
//    public ResponseEntity<List<Player>> getAllPlayers(@RequestParam(required = false) String name) {
//        try {
//            List<Player> Players = new ArrayList<>();
//
//            if (name == null)
//                playerRepos.findAll().forEach(Players::add);
//            else
//                playerRepos.findByName(name).forEach(Players::add);
//
//            if (Players.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(Players, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/player/{id}")
    public ResponseEntity<?> getPlayerById(@PathVariable("id") long id) {
        return plService.getPlayerById(id);
    }

    @PostMapping("/player")
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
        return plService.addPlayer(player);
    }

//    @PutMapping("/player/{id}")
//    public ResponseEntity<Player> updatePlayer(@PathVariable("id") long id, @RequestBody Player Player) {
//        try{
//                Optional<Player> PlayerOp = playerRepos.findById(id);
//
//
//            if (PlayerOp.isPresent()) {
//                Player player = PlayerOp.get();
//                player.setName(Player.getName());
//                player.setBithDay(Player.getBithDay());
//                player.setT_shirt_Number(Player.getT_shirt_Number());
//                return new ResponseEntity<>(playerRepos.save(player), HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/player/{id}")
//    public ResponseEntity<HttpStatus> deletePlayer(@PathVariable("id") long id) {
//        try {
//            playerRepos.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/players")
//    public ResponseEntity<HttpStatus> deleteAllPlayers() {
//        try {
//            playerRepos.deleteAll();
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
}
