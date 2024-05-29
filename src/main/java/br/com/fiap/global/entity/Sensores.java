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
@Table(name = "Sensores")
public class Sensores {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SENSORES")
    @SequenceGenerator(name = "SQ_SENSORES", sequenceName = "SQ_SENSORES", allocationSize = 1)
    @Column(name = "ID_Sensor")
    private Long id;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Localizacao")
    private String localizacao;

    @Column(name = "Data_Instalacao")
    private String dataInstalacao;

    @Column(name = "Status")
    private String status;
}