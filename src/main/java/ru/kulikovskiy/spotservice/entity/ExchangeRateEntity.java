package ru.kulikovskiy.spotservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import ru.kulikovskiy.spotservice.model.ExchangeRate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
@Table(name = "exchange_rate")
public class ExchangeRateEntity {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id")
    private String id;
    @Column(name = "ccypair")
    private String ccypair;
    @Column(name = "tick_time")
    private LocalDateTime tickTime;
    @Column(name = "spot")
    private double spot;

    public ExchangeRateEntity(String ccypair, LocalDateTime tickTime, double spot) {
        this.ccypair = ccypair;
        this.tickTime = tickTime;
        this.spot = spot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRateEntity that = (ExchangeRateEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
