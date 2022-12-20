package cloud.avions.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data // générateur des getters & setters
@Entity
@Table(name = "assurance")
public class Assurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_payement", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePaye;

    @Column(name = "date_expiration", nullable = false)
    private Date DateFin;

    @ManyToOne
    @JoinColumn(name = "avion_id")
    private Avion avion;
}
