package tn.esb.j2ee.competitionServer.Models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Stadium {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NonNull //@NotBlank
    private String name;
    @NonNull
    private int capacity;
    @OneToOne(mappedBy="its_stadium")
    private Team team_Owner;
}
