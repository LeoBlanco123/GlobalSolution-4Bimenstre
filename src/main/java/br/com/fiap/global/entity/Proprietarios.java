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
@Table(name = "Proprietarios")
public class Proprietarios {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROPRIETARIOS")
    @SequenceGenerator(name = "SQ_PROPRIETARIOS", sequenceName = "SQ_PROPRIETARIOS", allocationSize = 1)
    @Column(name = "ID_Proprietario")
    private Long id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Endereco")
    private String endereco;

    @Column(name = "Telefone")
    private String telefone;

    @Column(name = "Email")
    private String email;
}