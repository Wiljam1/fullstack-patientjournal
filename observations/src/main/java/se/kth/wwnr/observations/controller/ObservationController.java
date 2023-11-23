package se.kth.wwnr.observations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.kth.wwnr.observations.model.Observation;
import se.kth.wwnr.observations.services.ObservationService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ObservationController {

    @Autowired
    private ObservationService observationService;

    @GetMapping("/observations")
    List<Observation> getAllObservations() {
        return observationService.getAll();
    }

    @GetMapping("/observation/{patientId}")
    List<Observation> getObservation(@PathVariable Long patientId) {
        return observationService.getByPatientId(patientId);
    }

    @PostMapping("/observation")
    Observation createObservation(@RequestBody Observation observation) {
        return observationService.create(observation);
    }
}
