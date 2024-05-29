package br.com.fiap.global.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "Monitoramentos")
public class Monitoramentos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MONITORAMENTOS")
    @SequenceGenerator(name = "SQ_MONITORAMENTOS", sequenceName = "SQ_MONITORAMENTOS", allocationSize = 1)
    @Column(name = "ID_Monitoramento")
    private Long id;

    @Column(name = "Data")
    private String data;

    @Column(name = "Hora")
    private String hora;

    @Column(name = "Localizacao")
    private String localizacao;

    @Column(name = "Nivel_Poluicao")
    private Double nivelPoluicao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ID_Embarcacao",
            referencedColumnName = "ID_Embarcacao",
            foreignKey = @ForeignKey(name = "FK_EMBARCACAO_MONITOR")
    )
    private Embarcacoes embarcacao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ID_Sensor",
            referencedColumnName = "ID_Sensor",
            foreignKey = @ForeignKey(name = "FK_SENSOR_MONITOR")
    )
    private Sensores sensor;
}