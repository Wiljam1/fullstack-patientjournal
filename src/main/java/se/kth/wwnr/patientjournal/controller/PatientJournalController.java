package se.kth.wwnr.patientjournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.kth.wwnr.patientjournal.model.Condition;
import se.kth.wwnr.patientjournal.model.Encounter;
import se.kth.wwnr.patientjournal.model.Observation;
import se.kth.wwnr.patientjournal.services.ConditionService;
import se.kth.wwnr.patientjournal.services.EncounterService;
import se.kth.wwnr.patientjournal.services.ObservationService;

import java.util.List;

@RestController
@CrossOrigin
public class PatientJournalController {

    @Autowired
    private ObservationService observationService;
    @Autowired
    private EncounterService encounterService;
    @Autowired
    private ConditionService conditionService;

    @GetMapping("/observations")
    List<Observation> getAllObservations() {
        return observationService.getAll();
    }

    @GetMapping("/observation/patient/{patientId}")
    List<Observation> getPatientObservations(@PathVariable Long patientId) {
        return observationService.getByPatientId(patientId);
    }

    @GetMapping("/observation/staff/{performerId}")
    List<Observation> getPerformerObservations(@PathVariable Long performerId) {
        return observationService.getByPerformerId(performerId);
    }

    @PostMapping("/observation")
    Observation createObservation(@RequestBody Observation observation) {
        return observationService.create(observation);
    }

    @GetMapping("/encounters")
    List<Encounter> getAllEncounters() {
        return encounterService.getAll();
    }

    @GetMapping("/encounter/patient/{patientId}")
    List<Encounter> getPatientEncounters(@PathVariable Long patientId) {
        return encounterService.getByPatientId(patientId);
    }

    @GetMapping("/encounter/staff/{practitionerId}")
    List<Encounter> getPractitionerEncounters(@PathVariable Long practitionerId) {
        return encounterService.getByPractitionerId(practitionerId);
    }

    @PostMapping("/encounter")
    Encounter createEncounter(@RequestBody Encounter encounter) {
        return encounterService.create(encounter);
    }

    @GetMapping("/conditions")
    List<Condition> getAllConditions() {
        return conditionService.getAll();
    }

    @GetMapping("/condition/patient/{patientId}")
    List<Condition> getPatientConditions(@PathVariable Long patientId) {
        return conditionService.getByPatientId(patientId);
    }

    @GetMapping("/condition/staff/{doctorId}")
    List<Condition> getDoctorConditions(@PathVariable Long doctorId) {
        return conditionService.getByDoctorId(doctorId);
    }

    @PostMapping("/condition")
    Condition createCondition(@RequestBody Condition condition) {
        return conditionService.create(condition);
    }
}
