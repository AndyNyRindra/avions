package cloud.avions.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "avion")
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "matricule", nullable = false)
    private String matricule;

    @ManyToOne
    @JoinColumn(name = "marque_id", nullable = false)
    private Marque marque;

    @Lob
    private byte[] img;

}
