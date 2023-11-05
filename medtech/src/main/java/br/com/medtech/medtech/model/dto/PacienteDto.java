package br.com.medtech.medtech.model.dto;

import br.com.medtech.medtech.model.entities.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PacienteDto{

    private Long id;
    private String nome;
    private String cartaoSus;
    private String registroGeral;
    private String cpf;
    private String dataNascimento;
    private String nomeMae;
    private String nomePai;
    private String endereco;
    private String observacoes;

    public PacienteDto(){}

    public PacienteDto(Paciente paciente){
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.cartaoSus = paciente.getCartaoSus();
        this.registroGeral = paciente.getRegistroGeral();
        this.cpf = paciente.getCpf();
        this.dataNascimento = paciente.getDataNascimento();
        this.nomeMae = paciente.getNomeMae();
        this.nomePai = paciente.getNomePai();
        this.endereco = paciente.getEndereco();
        this.observacoes = paciente.getObservacoes();

    }
}
