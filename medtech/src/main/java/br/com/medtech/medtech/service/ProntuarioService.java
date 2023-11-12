package br.com.medtech.medtech.service;

import br.com.medtech.medtech.enums.EnumEstadoProntuario;
import br.com.medtech.medtech.model.dto.PacienteDto;
import br.com.medtech.medtech.model.dto.ProntuarioDto;
import br.com.medtech.medtech.model.entities.Paciente;
import br.com.medtech.medtech.model.entities.Prontuario;
import br.com.medtech.medtech.model.form.ProntuarioForm;
import br.com.medtech.medtech.repository.PacienteRepository;
import br.com.medtech.medtech.repository.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProntuarioService {

    @Autowired
    ProntuarioRepository prontuarioRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    private Prontuario convertToBusiness(ProntuarioForm form) {
        Prontuario prontuario = new Prontuario();
        prontuario.setPaciente(form.getPaciente());
        prontuario.setPeso(form.getPeso());
        prontuario.setAltura(form.getAltura());
        prontuario.setUrgencia(form.getUrgencia());
        prontuario.setEstado(form.getEstado());
        prontuario.setPressao(form.getPressao());
        prontuario.setSaturacao(form.getSaturacao());
        prontuario.setQueixa(form.getQueixa());
        prontuario.setObservacoes(form.getObservacoes());
        prontuario.setDataCriacao(form.getDataCriacao());
        return prontuario;
    }

    private ProntuarioDto convertToDto(Prontuario prontuario) {
        ProntuarioDto dto = new ProntuarioDto();
        PacienteDto pacienteDto = new PacienteDto();
        dto.setId(dto.getId());
        dto.setPaciente(dto.getPaciente());
        dto.setPeso(dto.getPeso());
        dto.setAltura(dto.getAltura());
        dto.setUrgencia(dto.getUrgencia());
        dto.setEstado(dto.getEstado());
        dto.setPressao(dto.getPressao());
        dto.setSaturacao(dto.getSaturacao());
        dto.setQueixa(dto.getQueixa());
        dto.setObservacoes(dto.getObservacoes());
        prontuario.setPaciente(convertToPaciente(dto.getPaciente()));
        prontuario.setPeso(dto.getPeso());
        prontuario.setAltura(dto.getAltura());
        prontuario.setUrgencia(dto.getUrgencia());
        prontuario.setEstado(dto.getEstado());
        prontuario.setPressao(dto.getPressao());
        prontuario.setSaturacao(dto.getSaturacao());
        prontuario.setQueixa(dto.getQueixa());
        prontuario.setObservacoes(dto.getObservacoes());
        prontuario.setDataCriacao(dto.getDataCriacao());

        return dto;
    }

    private Paciente convertToPaciente(PacienteDto dto) {
        Paciente paciente = new Paciente();
        paciente.setId(dto.getId());
        paciente.setNome(dto.getNome());
        paciente.setCartaoSus(dto.getCartaoSus());
        paciente.setCpf(dto.getCpf());
        paciente.setDataNascimento(dto.getDataNascimento());
        paciente.setRegistroGeral(dto.getRegistroGeral());
        paciente.setNomePai(dto.getNomePai());
        paciente.setEndereco(dto.getEndereco());
        paciente.setObservacoes(dto.getObservacoes());
        return paciente;
    }

    public final static class ConvertProntuarioToDtoModel {

        public ConvertProntuarioToDtoModel() {}

        public ConvertProntuarioToDtoModel(Prontuario prontuario, Paciente paciente) {
            this.prontuario = prontuario;
            this.paciente = paciente;
        }

        public ConvertProntuarioToDtoModel(ProntuarioDto prontuarioDto, PacienteDto pacienteDto) {
            this.prontuarioDto = prontuarioDto;
            this.pacienteDto = pacienteDto;
        }

        public Prontuario prontuario;
        public Paciente paciente;

        public ProntuarioDto prontuarioDto;
        public PacienteDto pacienteDto;
    }

    private static List<ProntuarioDto> convertListToDto(List<ConvertProntuarioToDtoModel> prontuarios) {
        return prontuarios.stream().map((p) -> new ProntuarioDto(p.prontuario, p.paciente)).collect(Collectors.toList());
    }

    public ProntuarioDto createProntuario(ProntuarioForm form) {
        Prontuario prontuario = convertToBusiness(form);
        prontuario = prontuarioRepository.save(prontuario);
        return convertToDto(prontuario);
    }

    public List<ProntuarioDto> findAllProntuarios() {
        List<Prontuario> all = prontuarioRepository.findAll();
        List<ConvertProntuarioToDtoModel> request = all.stream().map((prontuario ->
                new ConvertProntuarioToDtoModel
                        (prontuario, pacienteRepository.findById(prontuario.getPaciente().getId()).get()))).toList();
        return convertListToDto(request);
    }

    public List<ProntuarioDto> findProntuariosById(Long id) {
        Optional<Prontuario> all = prontuarioRepository.findById(id);
        List<ConvertProntuarioToDtoModel> request = all.stream().map((prontuario ->
                new ConvertProntuarioToDtoModel
                        (prontuario, pacienteRepository.findById(prontuario.getPaciente().getId()).get()))).toList();
        return convertListToDto(request);
    }

    public List<ProntuarioDto> findProntuariosByEstado(Enum<EnumEstadoProntuario>estadoProntuarioEnum) {
        Optional<Prontuario> all = prontuarioRepository.findByEstado(estadoProntuarioEnum);
        List<ConvertProntuarioToDtoModel> request = all.stream().map((prontuario ->
                new ConvertProntuarioToDtoModel
                        (prontuario, pacienteRepository.findById(prontuario.getPaciente().getId()).get()))).toList();
        return convertListToDto(request);
    }

    public List<ProntuarioDto> findByUrgenciaEDataCriacao() {
        Optional<Prontuario> all = prontuarioRepository.findByEstadoOrderByUrgenciaAscDataCriacaoAsc(EnumEstadoProntuario.ABERTO);
        List<ConvertProntuarioToDtoModel> request = all.stream().map((prontuario ->
                new ConvertProntuarioToDtoModel
                        (prontuario, pacienteRepository.findById(prontuario.getPaciente().getId()).get()))).toList();
        return convertListToDto(request);
    }

    public ProntuarioDto findProntuarioByPacienteID(Long pacienteId) {
        Optional<Prontuario> optional = prontuarioRepository.findByPacienteId(pacienteId);
        return optional.map(this::convertToDto).orElse(null);
    }
}
