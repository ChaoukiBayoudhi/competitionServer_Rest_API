package tn.esb.j2ee.competitionServer.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;
    @ManyToMany(mappedBy="its_competion")
    private Set<Team> teamsOfCompetion=new HashSet<>();


}
