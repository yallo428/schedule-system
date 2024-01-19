package org.example.jdbcschedulemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
public class CreateScheduleDTO {
    private String userName;
    private String password;
    private String title;
    private String contents;
}
