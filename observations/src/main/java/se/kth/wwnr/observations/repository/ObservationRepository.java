package se.kth.wwnr.observations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.kth.wwnr.observations.model.Observation;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
}
