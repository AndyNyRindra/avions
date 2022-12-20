package cloud.avions.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "kilometrage")
public class Kilometrage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "km_debut", nullable = false)
    private double km_debut;

    @Column(name = "km_fin", nullable = false)
    private double km_fin;

    @ManyToOne
    @JoinColumn(name = "avion_id")
    @JsonIgnore
    private Avion avion;
}
