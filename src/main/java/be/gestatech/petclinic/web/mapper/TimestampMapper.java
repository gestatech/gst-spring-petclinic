package be.gestatech.petclinic.web.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import org.springframework.stereotype.Component;

@Component
public class TimestampMapper {

    public String mapToString(Long timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), TimeZone.getTimeZone(ZoneId.systemDefault()).toZoneId())
                .format(formatter);
    }
}
