package se.kth.wwnr.patientjournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.kth.wwnr.patientjournal.model.Condition;

import java.util.List;

public interface ConditionRepository extends JpaRepository<Condition, Long> {
    List<Condition> findByPatientId(Long patientId);

    List<Condition> findByDoctorId(Long doctorId);
}
