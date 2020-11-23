package app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class DateController {

    /*
    Request body
    {
        "localDate": "2019-12-31",
        "localTime": "23:59:59",
        "localDateTime": "2019-12-31T23:59:59"
    }

    Response body
    {
        "localDate": "2020-01-01",
        "localTime": "00:59:59",
        "localDateTime": "2020-01-01T23:59:59"
    }
    * */

    @PostMapping(path = "/api/date")
    public @ResponseBody
    DateDto getDateMessage(@RequestBody DateDto dateDto) {
        return dateDto.plus(1);
    }

}
