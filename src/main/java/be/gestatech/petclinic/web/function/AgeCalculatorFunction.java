package be.gestatech.petclinic.web.function;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class AgeCalculatorFunction {

    public Integer compute(Long dateOfBirth) {
        int age = 0;
        LocalDate birthDate = new Timestamp(dateOfBirth).toLocalDateTime().toLocalDate();
        if (Objects.nonNull(birthDate)) {
            age = Period.between(birthDate, LocalDate.now()).getYears();
        }
        return age;
    }
}
