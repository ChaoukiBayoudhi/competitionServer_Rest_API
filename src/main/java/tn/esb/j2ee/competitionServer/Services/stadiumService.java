package tn.esb.j2ee.competitionServer.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.j2ee.competitionServer.Models.Stadium;
import tn.esb.j2ee.competitionServer.Repositories.stadiumRepository;

import java.util.List;
import java.util.Optional;

@Service
public class stadiumService {
    private stadiumRepository stadiumRepos;

    @Autowired
    public stadiumService(stadiumRepository stadiumRepos) {
        this.stadiumRepos = stadiumRepos;
    }
    public ResponseEntity<List<Stadium>> getAllStadiums()
    {
        List<Stadium> lststds=stadiumRepos.findAll();
        if(lststds.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(lststds,HttpStatus.OK);
    }
    public ResponseEntity<Stadium> getStadiumById(Long id)
    {
        Optional<Stadium> result=stadiumRepos.findById(id);
        if(result.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(result.get(),HttpStatus.OK);

    }
//    public ResponseEntity<Stadium> addStadium(Stadium st)
//    {
//        List<Stadium> lst1=stadiumRepos.findByName(st.getName());
//    }
//    public ResponseEntity<Stadium> updateStadium(Long id,Stadium newStadium)
//    {
//
//    }
//    public ResponseEntity DeleteStadium(Long id)
//    {
//
//    }

}
