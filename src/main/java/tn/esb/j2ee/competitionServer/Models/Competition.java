package tn.esb.j2ee.competitionServer.Models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
//or
//@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Competition {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String country;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToMany(mappedBy="its_competion")
    private Set<Team> teamsOfCompetion=new HashSet<>();


}
