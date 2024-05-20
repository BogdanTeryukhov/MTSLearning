package org.mts.repository;

import org.mts.dto.CreatureDTO;
import org.mts.entity.Creature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreatureRepository extends JpaRepository<Creature, Long> {
    Optional<Creature> findCreatureById(Long id);
}
