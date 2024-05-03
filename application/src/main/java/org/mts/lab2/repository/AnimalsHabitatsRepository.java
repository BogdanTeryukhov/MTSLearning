package org.mts.lab2.repository;

import org.mts.lab2.entity.AnimalsHabitats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsHabitatsRepository extends JpaRepository<AnimalsHabitats, Long> {
}
