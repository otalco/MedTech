package br.com.medtech.medtech.controller;

import br.com.medtech.medtech.enums.EnumEstadoProntuario;
import br.com.medtech.medtech.model.dto.PacienteDto;
import br.com.medtech.medtech.model.dto.ProntuarioDto;
import br.com.medtech.medtech.model.entities.Paciente;
import br.com.medtech.medtech.model.entities.Prontuario;
import br.com.medtech.medtech.model.form.PacienteForm;
import br.com.medtech.medtech.model.form.ProntuarioForm;
import br.com.medtech.medtech.service.PacienteService;
import br.com.medtech.medtech.service.ProntuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hibernate.engine.spi.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/prontuarios", produces = {"application/json"})
@Tag(name = "Medtech API")
public class ProntuarioController {

    @Autowired
    private ProntuarioService prontuarioService;

    @Autowired
    private PacienteService pacienteService;

    @Operation(summary = "Retorna lista simples de todos os prontuários do sistema", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")})
    @GetMapping("/lista-simples")
    public List<ProntuarioDto> listaSimples() {
        return prontuarioService.findAllProntuarios();
    }

    @Operation(summary = "Retorna prontuários por ID", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")})
    @GetMapping("/{id}")
    public List<ProntuarioDto> findProntuarioById(@PathVariable("id") Long id) {
        return prontuarioService.findProntuariosById(id);
    }

    @Operation(summary = "Retorna prontuários filtrados por estado ABERTO, FECHADO e REABERTO",method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")})
    @GetMapping("/estado/{estadoProntuarioEnum}")
    public List<ProntuarioDto> findProntuariosByEstado(@PathVariable("estadoProntuarioEnum") EnumEstadoProntuario estadoProntuarioEnum) {
        List<ProntuarioDto> all = prontuarioService.findProntuariosByEstado(estadoProntuarioEnum);

        List<ProntuarioDto> result = new ArrayList<>();

        for (ProntuarioDto prontuario : all) {
            PacienteDto paciente = pacienteService.findPacienteById(prontuario.getPaciente().getId());

            if (paciente != null) {
                ProntuarioService.ConvertProntuarioToDtoModel convertModel = new ProntuarioService.ConvertProntuarioToDtoModel(prontuario, paciente);
                result.add(new ProntuarioDto(convertModel.prontuario, convertModel.paciente));
            }
        }

        return result;
    }

    @Operation(summary = "Retorna o prontuário aberto com maior nível de urgência cadastrado a mais tempo",method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")})
    @GetMapping("/proxima-urgencia")
    public List<ProntuarioDto> findNextUrgencia(){
        return prontuarioService.findByUrgenciaEDataCriacao();
    }

    @Operation(summary = "Registra um prontuário",method = "POST")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Prontuário salvo com sucesso")})
    @PostMapping("/prontuario")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProntuarioDto insereProntuario(@RequestBody @Valid ProntuarioForm prontuarioForm){
        return prontuarioService.createProntuario(prontuarioForm);
    }

}
