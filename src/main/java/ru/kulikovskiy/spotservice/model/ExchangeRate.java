package ru.kulikovskiy.spotservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
public class ExchangeRate {
    private String ccypair;
    private LocalDateTime tickTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRate that = (ExchangeRate) o;
        return Objects.equals(ccypair, that.ccypair) &&
                Objects.equals(tickTime, that.tickTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ccypair, tickTime);
    }
}
