package br.com.medtech.medtech.controller;

import br.com.medtech.medtech.model.dto.PacienteDto;
import br.com.medtech.medtech.model.form.PacienteForm;
import br.com.medtech.medtech.model.form.PacienteUpdateForm;
import br.com.medtech.medtech.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<PacienteDto> list (){
        return pacienteService.findAllPacientes();
    }

    @GetMapping("/{id}")
    public PacienteDto findById(@PathVariable("id") Long id){
        return pacienteService.findPacienteById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PacienteDto register (@RequestBody @Valid PacienteForm pacienteForm){
        return pacienteService.createPaciente(pacienteForm);
    }

    @PutMapping("/{id}")
    public PacienteDto updateById(@RequestBody PacienteUpdateForm form , @PathVariable("id") Long id){
        return pacienteService.updateById(form,id);
    }

    @DeleteMapping("/{id}")
    public PacienteDto deleteById(@PathVariable("id") Long id){
        return pacienteService.deleteById(id);
    }

}
