package se.kth.wwnr.patientjournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;
import se.kth.wwnr.patientjournal.keycloak.SecurityUtils;
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
        if (SecurityUtils.hasRole("doctor")) {
            return observationService.getAll();
        } else {
            throw new AccessDeniedException("Not authorized: Requires doctor role");
        }
    }

    @GetMapping("/observation/patient/{patientId}")
    public List<Observation> getPatientObservations(@PathVariable Long patientId) {
        return observationService.getByPatientId(patientId);
    }

    @GetMapping("/observation/staff/{performerId}")
    List<Observation> getPerformerObservations(@PathVariable Long performerId) {
        return observationService.getByPerformerId(performerId);
    }

    @PostMapping("/observation")
    Observation createObservation(@RequestBody Observation observation) {
        if (SecurityUtils.hasRole("doctor")) {
            return observationService.create(observation);
        } else {
            throw new AccessDeniedException("Not authorized: Requires doctor role");
        }
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
        if (SecurityUtils.hasRole("doctor")) {
            return encounterService.create(encounter);
        } else {
            throw new AccessDeniedException("Not authorized: Requires doctor role");
        }
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
        if (SecurityUtils.hasRole("doctor")) {
            return conditionService.create(condition);
        } else {
            throw new AccessDeniedException("Not authorized: Requires doctor role");
        }
    }
}
