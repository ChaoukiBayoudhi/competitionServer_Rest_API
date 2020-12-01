package tn.esb.j2ee.competitionServer.Models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private LocalDate creationDate;
    private int nbPlayers;
    @OneToMany(mappedBy="his_team", cascade=CascadeType.ALL)
    private Set<Player> players=new HashSet<>();//un team est formé de plusieurs players
    @OneToOne(cascade=CascadeType.ALL)
    //emp(id,name,sal,deptname#)
    //5 employés qui travaillent dans dept "marketing"
    //dept(deptname,adress)
    //1 ligne qui decrit le dept "marketing"
    @JoinColumn(name ="stadium_id",referencedColumnName = "id")
    private Stadium its_stadium;
    @ManyToMany (cascade=CascadeType.ALL)
    @JoinTable(name ="team_competition",
            joinColumns=
                    @JoinColumn(name ="team_id",referencedColumnName = "id"),
            
            inverseJoinColumns=
                    @JoinColumn(name ="competition_id",referencedColumnName ="id")
    )
    private Set<Competition> its_competion=new HashSet<>();

    public Team(@NonNull String name, @NonNull LocalDate creationDate, int nbPlayers) {
        this.name = name;
        this.creationDate = creationDate;
        this.nbPlayers = nbPlayers;
    }
}
