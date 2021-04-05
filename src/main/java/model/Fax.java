package model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Fax {

    private String from;
    private String subject;
    private LocalDate date;
}
