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
@Table(name = "Embarcacoes")
public class Embarcacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EMBARCACOES")
    @SequenceGenerator(name = "SQ_EMBARCACOES", sequenceName = "SQ_EMBARCACOES", allocationSize = 1)
    @Column(name = "ID_Embarcacao")
    private Long id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Bandeira")
    private String bandeira;

    @Column(name = "Capacidade")
    private Double capacidade;

    @Column(name = "Ano_Fabricacao")
    private Integer anoFabricacao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "Proprietario",
            referencedColumnName = "ID_Proprietario",
            foreignKey = @ForeignKey(name = "FK_PROPRIETARIO_EMB")
    )
    private Proprietarios proprietario;
}