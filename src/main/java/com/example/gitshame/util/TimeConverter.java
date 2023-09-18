package com.example.gitshame.util;

import java.time.*;

public class TimeConverter {

    public static Instant getEstonianTimeZoneInstant() {
        return LocalDateTime.now().plusHours(3).atZone(ZoneId.of("Europe/Tallinn")).toInstant();
    }
}
