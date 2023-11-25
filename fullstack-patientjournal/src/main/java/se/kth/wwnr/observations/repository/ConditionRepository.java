package se.kth.wwnr.observations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.kth.wwnr.observations.model.Condition;

import java.util.List;

public interface ConditionRepository extends JpaRepository<Condition, Long> {
    List<Condition> findByPatientId(Long patientId);
}
