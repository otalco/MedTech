package br.com.medtech.medtech.model.dto;

import br.com.medtech.medtech.enums.EnumEstadoProntuario;
import br.com.medtech.medtech.enums.EnumUrgencia;
import br.com.medtech.medtech.model.entities.Paciente;
import br.com.medtech.medtech.model.entities.Prontuario;
import lombok.Data;

import java.util.Date;

@Data
public class ProntuarioDto {

    private Long id;
    private double peso;
    private double altura;
    private EnumUrgencia urgencia;
    private EnumEstadoProntuario estado;
    private String pressao;
    private String saturacao;
    private String queixa;
    private String observacoes;
    private Date dataCriacao;

    private PacienteDto paciente;

    public ProntuarioDto() {
    }

    public ProntuarioDto(Prontuario prontuario, Paciente paciente) {
        this.id = prontuario.getId();
        this.peso = prontuario.getPeso();
        this.altura = prontuario.getAltura();
        this.urgencia = prontuario.getUrgencia();
        this.estado = prontuario.getEstado();
        this.pressao = prontuario.getPressao();
        this.saturacao = prontuario.getSaturacao();
        this.queixa = prontuario.getQueixa();
        this.dataCriacao = prontuario.getDataCriacao();

        this.paciente = new PacienteDto();
        this.paciente.setId(paciente.getId());
    }

    public ProntuarioDto(Prontuario prontuario, Paciente paciente, EnumEstadoProntuario estado) {
        this.id = prontuario.getId();
        this.peso = prontuario.getPeso();
        this.altura = prontuario.getAltura();
        this.urgencia = prontuario.getUrgencia();
        this.estado = prontuario.getEstado();
        this.pressao = prontuario.getPressao();
        this.saturacao = prontuario.getSaturacao();
        this.queixa = prontuario.getQueixa();
        this.dataCriacao = prontuario.getDataCriacao();

        this.paciente = new PacienteDto();
        this.paciente.setId(paciente.getId());
    }
}
