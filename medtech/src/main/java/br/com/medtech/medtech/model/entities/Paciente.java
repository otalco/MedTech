package br.com.medtech.medtech.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Prontuario> prontuarios;

    @Column(name = "nome", nullable = false)
    @Size(max = 65)
    private String nome;

    @Column(name = "cartaoSus", unique = true)
    @Size(max = 15)
    private String cartaoSus;

    @Column(name = "registroGeral", unique = true)
    @Size(max = 20)
    private String registroGeral;

    @Column(name = "cpf", unique = true)
    @Size(min = 11, max = 11)
    private String cpf;

    @Column(name = "dataNascimento", nullable = false)
    private String dataNascimento;

    @Column(name = "nomeMae", nullable = false)
    @Size(max = 65)
    private String nomeMae;

    @Column(name = "nomePai")
    @Size(max = 65)
    private String nomePai;

    @Column(name = "endereco")
    @Size(max = 100)
    private String endereco;

    @Column(name = "observacoes")
    @Size(max = 300)
    private String observacoes;

}
