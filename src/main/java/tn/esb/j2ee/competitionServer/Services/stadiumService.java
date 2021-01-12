package tn.esb.j2ee.competitionServer.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.j2ee.competitionServer.Models.Stadium;
import tn.esb.j2ee.competitionServer.Repositories.stadiumRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public ResponseEntity<Stadium> addStadium(Stadium st)
    {
        Optional<Stadium> lst1=findByName(st.getName());
        if(lst1.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        Stadium stadium=stadiumRepos.save(st);
        return new ResponseEntity<>(stadium,HttpStatus.CREATED);
    }

//    private List<Stadium> findByName(String name) {
//        return stadiumRepos.findAll().stream()
//             .filter(x->x.getName().equalsIgnoreCase(name))
//             .collect(Collectors.toList());
//    }
      private Optional<Stadium> findByName(String name) {
        return stadiumRepos.findAll().stream()
             .filter(x->x.getName().equalsIgnoreCase(name))
             .findFirst();
    }

    public ResponseEntity<Stadium> updateStadium(Long id,Stadium newStadium)
    {
        Optional<Stadium> res=stadiumRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Optional<Stadium> lst1=findByName(newStadium.getName());
        if(lst1.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        Stadium stadium=res.get();
        stadium.setId(newStadium.getId());
        //stadium.setName(newStadium.getName());
        Stadium st=stadiumRepos.save(stadium);
        return new ResponseEntity<>(st,HttpStatus.OK);
    }
    public ResponseEntity deleteStadium(Long id)
    {
        Optional<Stadium> res=stadiumRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        stadiumRepos.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
