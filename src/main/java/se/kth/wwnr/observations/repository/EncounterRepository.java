package se.kth.wwnr.observations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.kth.wwnr.observations.model.Encounter;

import java.util.List;

public interface EncounterRepository extends JpaRepository<Encounter, Long> {
    List<Encounter> findByPatientId(Long patientId);
    List<Encounter> findByPractitionerId(Long practitionerId);
}
