package app.controller;

import lombok.*;

import java.time.*;

@Getter
@Setter
public final class DateDto {
    private LocalDate localDate;
    private LocalTime localTime;
    private LocalDateTime localDateTime;

    public DateDto plus(int daysToPlus) {
        return new DateDto()
            .setLocalDate(localDate.plusDays(daysToPlus))
            .setLocalTime(localTime.plusHours(daysToPlus))
            .setLocalDateTime(localDateTime.plusDays(daysToPlus));
    }
}
