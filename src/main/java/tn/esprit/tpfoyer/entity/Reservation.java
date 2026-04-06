package tn.esprit.tpfoyer.entity;
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
    private Set<Etudiant> etudiantList = new HashSet<Etudiant>();

    @ManyToOne
    private Chambre chambre;

}
