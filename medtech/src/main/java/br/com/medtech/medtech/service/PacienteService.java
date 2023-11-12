package br.com.medtech.medtech.service;

import br.com.medtech.medtech.model.dto.PacienteDto;
import br.com.medtech.medtech.model.entities.Paciente;
import br.com.medtech.medtech.model.form.PacienteForm;
import br.com.medtech.medtech.model.form.PacienteUpdateForm;
import br.com.medtech.medtech.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public PacienteDto createPaciente(PacienteForm form) {
        Paciente paciente = convertToBusiness(form);
        paciente = pacienteRepository.save(paciente);
        return convertToDto(paciente);
    }

    public List<PacienteDto> findAllPacientes() {
        List<Paciente> all = pacienteRepository.findAll();
        return convertListToDto(all);
    }

    public PacienteDto findPacienteById(Long id) {
        Optional<Paciente> optional = pacienteRepository.findById(id);
        return optional.map(this::convertToDto).orElse(null);
    }

    private Paciente convertToBusiness(PacienteForm form) {
        Paciente paciente = new Paciente();
        paciente.setNome(form.getNome());
        paciente.setNomeMae(form.getNomeMae());
        paciente.setCpf(form.getCpf());
        paciente.setCartaoSus(form.getCartaoSus());
        paciente.setDataNascimento(form.getDataNascimento());
        paciente.setRegistroGeral(form.getRegistroGeral());
        paciente.setNomePai(form.getRegistroGeral());
        paciente.setEndereco(form.getEndereco());
        paciente.setObservacoes(form.getObservacoes());
        return paciente;
    }

    private PacienteDto convertToDto(Paciente paciente) {
        PacienteDto dto = new PacienteDto();
        dto.setId(dto.getId());
        dto.setNome(dto.getNome());
        dto.setCartaoSus(dto.getCartaoSus());
        dto.setCpf(dto.getCpf());
        dto.setDataNascimento(dto.getDataNascimento());
        paciente.setRegistroGeral(dto.getRegistroGeral());
        paciente.setNomePai(dto.getRegistroGeral());
        paciente.setEndereco(dto.getEndereco());
        paciente.setObservacoes(dto.getObservacoes());
        return dto;
    }

    private static List<PacienteDto> convertListToDto(List<Paciente> pacientes) {
        return pacientes.stream().map(PacienteDto::new).collect(Collectors.toList());
    }

    public PacienteDto updateById(PacienteUpdateForm form, Long id) {
        Optional<Paciente> optional = pacienteRepository.findById(id);
        if (optional.isPresent()) {
            Paciente obj = optional.get();
            if (form.getNome() != null) {
                obj.setNome(form.getNome());
            }
            if (form.getCpf() != null) {
                obj.setCpf(form.getCpf());
            }
            pacienteRepository.save(obj);
            return convertToDto(obj);
        }
        return null;
    }

    public PacienteDto deleteById(Long id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
        }
        return null;
    }
}
