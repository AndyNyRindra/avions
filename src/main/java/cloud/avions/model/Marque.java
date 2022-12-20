package cloud.avions.model;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "marque")
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom", nullable = false)
    private String nom;
}
