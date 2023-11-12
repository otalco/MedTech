package br.com.medtech.medtech.model.entities;

import br.com.medtech.medtech.enums.EnumEstadoProntuario;
import br.com.medtech.medtech.enums.EnumUrgencia;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "prontuarios")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @Column(name = "peso", nullable = false)
    private double peso;

    @Column(name = "altura")
    private double altura;

    @Column(name = "urgencia", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumUrgencia urgencia;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumEstadoProntuario estado;

    @Column(name = "pressao", nullable = false)
    @Size(max = 10)
    private String pressao;

    @Column(name = "saturacao", nullable = false)
    @Size(max = 10)
    private String saturacao;

    @Column(name = "queixa", nullable = false)
    @Size(max = 300)
    private String queixa;

    @Column(name = "observacoes")
    @Size(max = 50)
    private String observacoes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataCriacao", nullable = false)
    private Date dataCriacao;

    @PrePersist
    protected void onCreate() {
        dataCriacao = new Date();
        estado = EnumEstadoProntuario.ABERTO;
    }

}