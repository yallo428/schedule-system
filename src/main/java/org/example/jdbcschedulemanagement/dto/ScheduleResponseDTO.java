package org.example.jdbcschedulemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ScheduleResponseDTO {
    private String userName;
    private String password;

    private String title;
    private String contents;

    private LocalDateTime date;
}
