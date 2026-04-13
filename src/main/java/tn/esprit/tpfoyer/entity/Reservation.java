package tn.esprit.tpfoyer.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    private String idReservation;
    private Date anneeUniversitaire;
    private Boolean estvalide;

    @ManyToMany
    @JsonIgnore
    private Set<Etudiant> etudiantList = new HashSet<Etudiant>();

    @ManyToOne
    @JsonIgnore
    private Chambre chambre;

}
