package app;

import app.controller.DateDto;
import app.dto.SimpleDto;
import lombok.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.json.*;
import org.springframework.boot.test.json.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@JsonTest
public class LocalDateTimeTest {

    @Autowired
    private JacksonTester<DateDto> jacksonTester;
    @Autowired
    private JacksonTester<SimpleDto> simpleDtoJacksonTester;

    @SneakyThrows
    @Test
    public void test() {
        DateDto dateDto = jacksonTester.readObject("../dates.json");
        assertNotNull(dateDto);
    }

    @SneakyThrows
    @Test
    public void iso_localDateTime() {
        SimpleDto dto = simpleDtoJacksonTester.readObject("../custom_dates.json");
        assertNotNull( dto.getDateTimeIso() );
        assertNotNull( dto.getDateTimeWhitespace() );
    }

}
