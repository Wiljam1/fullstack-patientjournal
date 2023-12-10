package se.kth.wwnr.observations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.kth.wwnr.observations.model.Observation;

import java.util.List;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
    List<Observation> findByPatientId(Long patientId);

    List<Observation> findByPerformerId(Long performerId);
}
