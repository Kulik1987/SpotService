package ru.kulikovskiy.spotservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class SpotRequest {
    @JsonProperty("ccypair")
    private String ccypair;
    @JsonProperty("date")
    private String date;
    @JsonProperty("spot")
    private double spot;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpotRequest that = (SpotRequest) o;
        return Objects.equals(ccypair, that.ccypair) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ccypair, date);
    }
}
