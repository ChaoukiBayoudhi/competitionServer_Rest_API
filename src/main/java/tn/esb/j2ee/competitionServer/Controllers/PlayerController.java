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


    @GetMapping("/player/{id}")
    public ResponseEntity<?> getPlayerById(@PathVariable("id") long id) {
        return plService.getPlayerById(id);
    }

    @PostMapping("/player")
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
        return plService.addPlayer(player);
    }


}
