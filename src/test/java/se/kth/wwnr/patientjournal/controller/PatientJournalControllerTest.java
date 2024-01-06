package se.kth.wwnr.patientjournal.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import se.kth.wwnr.patientjournal.model.Condition;
import se.kth.wwnr.patientjournal.model.Encounter;
import se.kth.wwnr.patientjournal.model.Observation;
import se.kth.wwnr.patientjournal.services.ConditionService;
import se.kth.wwnr.patientjournal.services.EncounterService;
import se.kth.wwnr.patientjournal.services.ObservationService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class PatientJournalControllerTest {

    @MockBean
    private ObservationService observationService;
    @MockBean
    private EncounterService encounterService;
    @MockBean
    private ConditionService conditionService;

    @Autowired
    private PatientJournalController patientJournalController;

    @Test
    @WithMockUser
    void getAllObservations() {
        List<Observation> observations = Arrays.asList(new Observation(), new Observation());
        when(observationService.getAll()).thenReturn(observations);

        List<Observation> result = patientJournalController.getAllObservations();

        assertEquals(observations, result);
        verify(observationService, times(1)).getAll();
    }

    @Test
    @WithMockUser
    void getPatientObservations() {
        Long patientId = 1L;
        List<Observation> patientObservations = Arrays.asList(new Observation(), new Observation());
        when(observationService.getByPatientId(patientId)).thenReturn(patientObservations);

        List<Observation> result = patientJournalController.getPatientObservations(patientId);

        assertEquals(patientObservations, result);
        verify(observationService, times(1)).getByPatientId(patientId);
    }

    @Test
    @WithMockUser
    void getPerformerObservations() {
        Long performerId = 1L;
        List<Observation> performerObservations = Arrays.asList(new Observation(), new Observation());
        when(observationService.getByPerformerId(performerId)).thenReturn(performerObservations);

        List<Observation> result = patientJournalController.getPerformerObservations(performerId);

        assertEquals(performerObservations, result);
        verify(observationService, times(1)).getByPerformerId(performerId);
    }

    @Test
    @WithMockUser
    void createObservation() {
        Observation inputObservation = new Observation();
        when(observationService.create(any(Observation.class))).thenReturn(inputObservation);

        Observation createdObservation = patientJournalController.createObservation(inputObservation);

        assertNotNull(createdObservation);
        verify(observationService, times(1)).create(inputObservation);
    }

    @Test
    @WithMockUser
    void getAllEncounters() {
        List<Encounter> encounters = Arrays.asList(new Encounter(), new Encounter());
        when(encounterService.getAll()).thenReturn(encounters);

        List<Encounter> result = patientJournalController.getAllEncounters();

        assertEquals(encounters, result);
        verify(encounterService, times(1)).getAll();
    }

    @Test
    @WithMockUser
    void getPatientEncounters() {
        Long patientId = 1L;
        List<Encounter> patientEncounters = Arrays.asList(new Encounter(), new Encounter());
        when(encounterService.getByPatientId(patientId)).thenReturn(patientEncounters);

        List<Encounter> result = patientJournalController.getPatientEncounters(patientId);

        assertEquals(patientEncounters, result);
        verify(encounterService, times(1)).getByPatientId(patientId);
    }

    @Test
    @WithMockUser
    void getPractitionerEncounters() {
        Long practitionerId = 1L;
        List<Encounter> practitionerEncounters = Arrays.asList(new Encounter(), new Encounter());
        when(encounterService.getByPractitionerId(practitionerId)).thenReturn(practitionerEncounters);

        List<Encounter> result = patientJournalController.getPractitionerEncounters(practitionerId);

        assertEquals(practitionerEncounters, result);
        verify(encounterService, times(1)).getByPractitionerId(practitionerId);
    }

    @Test
    @WithMockUser
    void createEncounter() {
        Encounter inputEncounter = new Encounter();
        when(encounterService.create(any(Encounter.class))).thenReturn(inputEncounter);

        Encounter createdEncounter = patientJournalController.createEncounter(inputEncounter);

        assertNotNull(createdEncounter);
        verify(encounterService, times(1)).create(inputEncounter);
    }

    @Test
    @WithMockUser
    void getAllConditions() {
        List<Condition> conditions = Arrays.asList(new Condition(), new Condition());
        when(conditionService.getAll()).thenReturn(conditions);

        List<Condition> result = patientJournalController.getAllConditions();

        assertEquals(conditions, result);
        verify(conditionService, times(1)).getAll();
    }

    @Test
    @WithMockUser
    void getPatientConditions() {
        Long patientId = 1L;
        List<Condition> patientConditions = Arrays.asList(new Condition(), new Condition());
        when(conditionService.getByPatientId(patientId)).thenReturn(patientConditions);

        List<Condition> result = patientJournalController.getPatientConditions(patientId);

        assertEquals(patientConditions, result);
        verify(conditionService, times(1)).getByPatientId(patientId);
    }

    @Test
    @WithMockUser
    void getDoctorConditions() {
        Long doctorId = 1L;
        List<Condition> doctorConditions = Arrays.asList(new Condition(), new Condition());
        when(conditionService.getByDoctorId(doctorId)).thenReturn(doctorConditions);

        List<Condition> result = patientJournalController.getDoctorConditions(doctorId);

        assertEquals(doctorConditions, result);
        verify(conditionService, times(1)).getByDoctorId(doctorId);
    }

    @Test
    @WithMockUser
    void createCondition() {
        Condition inputCondition = new Condition();
        when(conditionService.create(any(Condition.class))).thenReturn(inputCondition);

        Condition createdCondition = patientJournalController.createCondition(inputCondition);

        assertNotNull(createdCondition);
        verify(conditionService, times(1)).create(inputCondition);
    }
}