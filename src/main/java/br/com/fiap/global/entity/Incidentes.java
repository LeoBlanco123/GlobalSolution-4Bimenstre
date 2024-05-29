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
@Table(name = "Incidentes")
public class Incidentes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_INCIDENTES")
    @SequenceGenerator(name = "SQ_INCIDENTES", sequenceName = "SQ_INCIDENTES", allocationSize = 1)
    @Column(name = "ID_Incidente")
    private Long id;

    @Column(name = "Data")
    private String data;

    @Column(name = "Descricao")
    private String descricao;

    @Column(name = "Tipo_Poluicao")
    private String tipoPoluicao;

    @Column(name = "Severidade")
    private String severidade;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ID_Embarcacao",
            referencedColumnName = "ID_Embarcacao",
            foreignKey = @ForeignKey(name = "FK_EMBARCACAO_INCIDENTE")
    )
    private Embarcacoes embarcacao;
}