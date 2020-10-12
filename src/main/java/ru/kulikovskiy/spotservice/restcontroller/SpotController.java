package ru.kulikovskiy.spotservice.restcontroller;

import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kulikovskiy.jkh.jkhdataloader.model.JkhDataLoaderAllResponse;
import ru.kulikovskiy.jkh.jkhdataloader.service.StreetService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/spot")
public class SpotController {

    @RequestMapping(value = "/loadAll", method = RequestMethod.GET)
    public ResponseEntity<JkhDataLoaderAllResponse> loadAll() {
        JkhDataLoaderAllResponse response = streetService.getAllStreetsJkh();
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/getBean",method = RequestMethod.GET)
    public @ResponseBody List<String> getBeanList() {
        return Arrays.asList(appContext.getBeanDefinitionNames());
    }
}
