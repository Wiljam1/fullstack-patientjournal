package se.kth.wwnr.patientjournal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.wwnr.patientjournal.model.Condition;
import se.kth.wwnr.patientjournal.repository.ConditionRepository;

import java.util.List;

@Service
public class ConditionService {

    @Autowired
    private ConditionRepository conditionRepository;

    public Condition create(Condition condition) {
        try {
            return conditionRepository.save(condition);
        } catch (Exception e) {
            throw new RuntimeException("Error saving Condition: " + condition);
        }
    }

    public List<Condition> getAll() {
        return conditionRepository.findAll();
    }

    public Condition getById(Long id) {
        return conditionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error getting Condition with id: " + id));
    }

    public List<Condition> getByPatientId(Long patientId) {
        return conditionRepository.findByPatientId(patientId);
    }
    public List<Condition> getByDoctorId(Long doctorId) {
        return conditionRepository.findByDoctorId(doctorId);
    }

}
