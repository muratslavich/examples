package app.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.time.*;

@Getter
@Setter
public class SimpleDto {
    @JsonProperty("local_date_time_iso")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    LocalDateTime dateTimeIso;

    @JsonProperty("local_date_time_iso_white")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dateTimeWhitespace;
}
