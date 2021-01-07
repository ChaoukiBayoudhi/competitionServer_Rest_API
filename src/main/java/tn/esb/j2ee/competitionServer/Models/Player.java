package tn.esb.j2ee.competitionServer.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;


import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
//or
//@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = "photo")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
///@Table(name = "tab_player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long Code;
    @NonNull
    private String Name;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate BithDay;
    @NonNull
    private int T_shirt_Number;
    private String Position;
    @Lob
    private byte[] photo;
    @ManyToOne
    //en SQL constraint fk1 team_id references Team(id)
    @JoinColumn(name ="team_id")
    private Team his_team;//un player joue dans un seul Team

    public Player(@NonNull String name, @NonNull LocalDate bithDay, int t_shirt_Number, String position, byte[] photo) {
        Name = name;
        BithDay = bithDay;
        T_shirt_Number = t_shirt_Number;
        Position = position;
        this.photo = photo;
    }

    }
