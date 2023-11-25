package se.kth.wwnr.observations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.kth.wwnr.observations.model.Condition;
import se.kth.wwnr.observations.model.Encounter;
import se.kth.wwnr.observations.model.Observation;
import se.kth.wwnr.observations.services.ConditionService;
import se.kth.wwnr.observations.services.EncounterService;
import se.kth.wwnr.observations.services.ObservationService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
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

    @GetMapping("/observation/{patientId}")
    List<Observation> getObservations(@PathVariable Long patientId) {
        return observationService.getByPatientId(patientId);
    }

    @PostMapping("/observation")
    Observation createObservation(@RequestBody Observation observation) {
        return observationService.create(observation);
    }

    @GetMapping("/encounters")
    List<Encounter> getAllEncounters() {
        return encounterService.getAll();
    }

    @GetMapping("/encounter/{patientId}")
    List<Encounter> getEncounters(@PathVariable Long patientId) {
        return encounterService.getByPatientId(patientId);
    }

    @PostMapping("/encounter")
    Encounter createEncounter(@RequestBody Encounter encounter) {
        return encounterService.create(encounter);
    }

    @GetMapping("/conditions")
    List<Condition> getAllConditions() {
        return conditionService.getAll();
    }

    @GetMapping("/condition/{patientId}")
    List<Condition> getConditions(@PathVariable Long patientId) {
        return conditionService.getByPatientId(patientId);
    }

    @PostMapping("/condition")
    Condition createCondition(@RequestBody Condition condition) {
        return conditionService.create(condition);
    }
}
