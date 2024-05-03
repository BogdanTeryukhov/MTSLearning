package org.mts.lab2.repository;

import org.mts.lab2.entity.AnimalsProviders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsProvidersRepository extends JpaRepository<AnimalsProviders, Long> {
}
