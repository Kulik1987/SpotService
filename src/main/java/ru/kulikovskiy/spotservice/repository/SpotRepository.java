package ru.kulikovskiy.spotservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kulikovskiy.spotservice.entity.ExchangeRateEntity;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SpotRepository extends JpaRepository<ExchangeRateEntity, String> {
    List<ExchangeRateEntity> findAllByTickTimeAfter(LocalDateTime dateTime);
}
