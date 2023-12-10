package se.kth.wwnr.observations.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.wwnr.observations.model.Observation;
import se.kth.wwnr.observations.repository.ObservationRepository;


import java.util.List;

@Service
public class ObservationService {

    @Autowired
    private ObservationRepository observationRepository;

    public Observation create(Observation observation) {
        try {
            return observationRepository.save(observation);
        } catch (Exception e) {
            throw new RuntimeException("Error saving Observation: " + observation);
        }
    }

    public List<Observation> getAll() {
        return observationRepository.findAll();
    }

    public Observation getById(Long id) {
        return observationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error getting Observation with id: " + id));
    }

    public List<Observation> getByPatientId(Long patientId) {
        return observationRepository.findByPatientId(patientId);
    }

    public List<Observation> getByPerformerId(Long performerId) {
        return observationRepository.findByPerformerId(performerId);
    }

}
