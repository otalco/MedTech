package br.com.medtech.medtech.model.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class PacienteUpdateForm {

    @NotBlank(message = "Nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "Nome da mãe não pode estar em branco")
    private String nomeMae;
    @CPF(message = "Número de CPF Inválido")
    private String Cpf;
    @NotBlank(message = "Número do Cartão SUS não pode estar em branco")
    private String cartaoSus;
    @NotNull(message = "Data de nascimento não pode estar em branco")
    private String dataNascimento;
    private String registroGeral;
    private String nomePai;
    private String endereco;
    private String observacoes;

}
