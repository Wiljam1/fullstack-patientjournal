package se.kth.wwnr.patientjournal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.wwnr.patientjournal.model.Encounter;
import se.kth.wwnr.patientjournal.repository.EncounterRepository;

import java.util.List;

@Service
public class EncounterService {

    @Autowired
    private EncounterRepository encounterRepository;

    public Encounter create(Encounter encounter) {
        try {
            return encounterRepository.save(encounter);
        } catch (Exception e) {
            throw new RuntimeException("Error saving Encounter: " + e);
        }
    }

    public List<Encounter> getAll() {
        return encounterRepository.findAll();
    }

    public Encounter getById(Long id) {
        return encounterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error getting Encounter with id: " + id));
    }

    public List<Encounter> getByPatientId(Long patientId) {
        return encounterRepository.findByPatientId(patientId);
    }

    public List<Encounter> getByPractitionerId(Long practitionerId) {
        return encounterRepository.findByPractitionerId(practitionerId);
    }

}
