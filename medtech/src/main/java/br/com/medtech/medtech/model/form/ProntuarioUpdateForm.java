package br.com.medtech.medtech.model.form;

import br.com.medtech.medtech.enums.EnumEstadoProntuario;
import br.com.medtech.medtech.enums.EnumUrgencia;
import br.com.medtech.medtech.model.entities.Paciente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class ProntuarioUpdateForm {

    @NotNull(message = "O paciente precisa estar definido")
    private Paciente paciente;
    @NotNull(message = "Peso não pode estar em branco")
    private double peso;
    private double altura;
    @NotNull(message = "Urgência não pode estar em branco")
    private EnumUrgencia urgencia;
    @NotNull(message = "O estado do prontuário deve ser aberto")
    private EnumEstadoProntuario estado;
    @NotBlank(message = "Pressão não pode estar em branco")
    private String pressao;
    @NotBlank(message = "Saturação não pode estar em branco")
    private String saturacao;
    @NotBlank(message = "Queixa não pode estar em branco")
    private String queixa;
    private String observacoes;
    @NotNull(message = "Data de criação deve estar definida")
    private Date dataCriacao;

}
