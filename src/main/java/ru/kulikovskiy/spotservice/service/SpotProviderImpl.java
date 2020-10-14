package ru.kulikovskiy.spotservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kulikovskiy.spotservice.entity.ExchangeRateEntity;
import ru.kulikovskiy.spotservice.model.ExchangeRate;
import ru.kulikovskiy.spotservice.repository.SpotRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@Service
@RequiredArgsConstructor
public class SpotProviderImpl implements SpotProvider {
    private final SpotRepository spotRepository;

    private CopyOnWriteArraySet<String> ccypairSet = new CopyOnWriteArraySet<>();
    private HashMap<ExchangeRate, Double> exchangeRateMap = new HashMap<>();


    @Override
    public synchronized void add(String ccypair, double spot, LocalDateTime tickTime) {
        if (ccypair.length() == 6) {
            String firstCurrency = ccypair.substring(0, 3);
            String secondCurrency = ccypair.substring(3);

            addCcyPair(ccypair, firstCurrency, secondCurrency);

            if ((ccypairSet.contains(firstCurrency)) && (ccypairSet.contains(secondCurrency))) {
                exchangeRateMap.put(new ExchangeRate(ccypair, tickTime), spot);
            }
        }
    }

    @Override
    public synchronized double get(String ccypair, LocalDateTime tikTime) {
        return exchangeRateMap.get(new ExchangeRate(ccypair, tikTime));

    }

    @Override
    public void init(int days) {

        LocalDateTime findDate = LocalDateTime.now().minusDays(Long.valueOf(days));
        List<ExchangeRateEntity> rateEntityArrayList = spotRepository.findAllByTickTimeAfter(findDate);
        rateEntityArrayList.stream().forEach(rate -> exchangeRateMap.put(new ExchangeRate(rate.getCcypair(), rate.getTickTime()), rate.getSpot()));
    }

    @PostConstruct
    public void init() {
        init(7);
    }

    private void addCcyPair(String ccypair, String firstCurrrency, String secondCurrency) {
        if (ccypairSet.size() < 100) {
            ccypairSet.add(firstCurrrency);
            if (ccypairSet.size() < 100) {
                ccypairSet.add(secondCurrency);
            }
        }
    }
}
