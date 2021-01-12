package tn.esb.j2ee.competitionServer.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esb.j2ee.competitionServer.Models.Stadium;
import tn.esb.j2ee.competitionServer.Repositories.stadiumRepository;
import tn.esb.j2ee.competitionServer.Services.stadiumService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stadiums")
public class stadiumController {
    @Autowired
    private stadiumService stadiumServ;

    @GetMapping("/all")
    public ResponseEntity<List<Stadium>> getStadiums()
    {
        return stadiumServ.getAllStadiums();
    }
    @GetMapping("/stadium/{id}")
    // http://localhost:9592/stadiums/stadium/11
    public ResponseEntity<Stadium> getStadium(@PathVariable Long id)
    {
        return stadiumServ.getStadiumById(id);
    }
    @PostMapping("/newstadium")
    public ResponseEntity<Stadium> addStadium(@Valid @RequestBody Stadium st)
    {
        return stadiumServ.addStadium(st);
    }
    @DeleteMapping("/stadium/{id}")
    public ResponseEntity deleteStadium(@PathVariable Long id)
    {
        return stadiumServ.deleteStadium(id);
    }
    @PutMapping("/stadium/{id}")
    public ResponseEntity<Stadium> updateStadium(@PathVariable Long id, @Valid @RequestBody Stadium st)
    {
        return stadiumServ.updateStadium(id,st);
    }


}
