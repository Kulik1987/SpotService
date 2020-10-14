package ru.kulikovskiy.spotservice.restcontroller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kulikovskiy.spotservice.model.SpotRequest;
import ru.kulikovskiy.spotservice.service.SpotProvider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "/spot")
@Slf4j
@RequiredArgsConstructor
public class SpotController {
    private final SpotProvider spotProvider;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody SpotRequest spotRequest) {
        if ((spotRequest != null) && (spotRequest.getCcypair() != null) && (spotRequest.getDate() != null)) {
            LocalDateTime tickTime = getLocalDateTime(spotRequest.getDate());
            spotProvider.add(spotRequest.getCcypair(), spotRequest.getSpot(), tickTime);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get(@RequestParam String ccypair,
                              @RequestParam String date) {
        if ((ccypair != null) && (date != null)) {
            LocalDateTime tickTime = getLocalDateTime(date);
            spotProvider.get(ccypair, tickTime);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    private LocalDateTime getLocalDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime tickTime = LocalDateTime.parse(date, formatter);
        return tickTime;
    }
}
