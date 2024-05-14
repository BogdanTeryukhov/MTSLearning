package org.mts.lab2.repository;

import org.mts.lab2.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidersRepository extends JpaRepository<Provider, Long> {
}
