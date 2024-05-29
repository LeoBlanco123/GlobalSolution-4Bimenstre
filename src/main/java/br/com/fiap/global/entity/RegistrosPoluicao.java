package br.com.fiap.global.entity;

import jakarta.persistence.Entity;

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
@Table(name = "RegistrosPoluicao")
public class RegistrosPoluicao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_REGISTROS_POLUICAO")
    @SequenceGenerator(name = "SQ_REGISTROS_POLUICAO", sequenceName = "SQ_REGISTROS_POLUICAO", allocationSize = 1)
    @Column(name = "ID_Registro")
    private Long id;

    @Column(name = "Data")
    private String data;

    @Column(name = "Hora")
    private String hora;

    @Column(name = "Localizacao")
    private String localizacao;

    @Column(name = "Tipo_Poluicao")
    private String tipoPoluicao;

    @Column(name = "Quantidade_Poluida")
    private Double quantidadePoluida;

    @Column(name = "Testemunhas")
    private String testemunhas;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ID_Embarcacao",
            referencedColumnName = "ID_Embarcacao",
            foreignKey = @ForeignKey(name = "FK_EMBARCACAO_REGISTRO")
    )
    private Embarcacoes embarcacao;
}
