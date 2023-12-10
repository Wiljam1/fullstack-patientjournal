package se.kth.wwnr.patientjournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.kth.wwnr.patientjournal.model.Encounter;

import java.util.List;

public interface EncounterRepository extends JpaRepository<Encounter, Long> {
    List<Encounter> findByPatientId(Long patientId);
    List<Encounter> findByPractitionerId(Long practitionerId);
}
