package tn.esb.j2ee.competitionServer.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esb.j2ee.competitionServer.Models.Stadium;
import tn.esb.j2ee.competitionServer.Repositories.stadiumRepository;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/stadiums")
public class stadiumController {
    @Autowired
    private stadiumRepository stdRepos;
    private final Logger log= LoggerFactory.getLogger(Stadium.class);
    @GetMapping("/all")
    public Collection<Stadium> getAllStadium()
    {
        return stdRepos.findAll();
    }
    @GetMapping("/stadium/{id}")
    public Optional<Stadium> getStadiumById(@PathVariable Long id)
    {
        return stdRepos.findById(id);
    }
    @PostMapping("/newstadium")
    public Stadium addStadium(@RequestBody Stadium std)
    {
        return stdRepos.save(std);
    }
}