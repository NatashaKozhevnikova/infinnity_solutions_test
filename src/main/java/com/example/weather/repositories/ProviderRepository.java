package com.example.weather.repositories;

import com.example.weather.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Optional<Provider> findFirstByType(Provider.ApiType type);
}
