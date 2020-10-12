package ru.kulikovskiy.spotservice.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;

/*
java 11
add cpmment
сервис курса валют.
 метод add - добавить новое значение курса валют
 get - получить курс валют на заданное время.
 CCYPAIR комбинации 6 символов "EURUSD" or "JPYRUB"
 SPOT пример значение 76.45
 должна быть потокобезопасна
 */
@Service
public class SpotProviderImpl implements SpotProvider {
    private HashMap<>
    @Override
    public void add(String ccypair, double spot, LocalDateTime tickTime) {
        if (ccypair.length() == 6) {

        }
    }

    @Override
    public double get(String ccypair, LocalDateTime dateTime) {
        return 0;
    }

    @Override
    public void init(int days) {

    }
}
