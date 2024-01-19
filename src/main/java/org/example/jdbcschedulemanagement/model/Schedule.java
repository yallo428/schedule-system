package org.example.jdbcschedulemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class Schedule {
    private Long id;

    private String userName;
    private String password;

    private String title;
    private String contents;

    private LocalDateTime date;

    public Schedule(String userName, String password, String title, String contents) {
        this.userName = userName;
        this.password = password;
        this.title = title;
        this.contents = contents;
        this.date = LocalDateTime.now();
    }
}
