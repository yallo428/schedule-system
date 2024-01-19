package org.example.jdbcschedulemanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateScheduleDTO {
    private String title;
    private String contents;
    private String userName;
}
