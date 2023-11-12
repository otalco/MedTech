package br.com.medtech.medtech.repository;

import br.com.medtech.medtech.enums.EnumEstadoProntuario;
import br.com.medtech.medtech.enums.EnumUrgencia;
import br.com.medtech.medtech.model.entities.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
    Optional<Prontuario> findByEstado(Enum<EnumEstadoProntuario> estado);

    Optional<Prontuario> findByEstadoOrderByUrgenciaAscDataCriacaoAsc(Enum<EnumEstadoProntuario> estado);

    Optional<Prontuario> findByPacienteId(Long pacienteId);
}
