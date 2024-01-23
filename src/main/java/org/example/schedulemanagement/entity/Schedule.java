package org.example.schedulemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.exception.PasswordMatchException;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    private String title;
    private String contents;

    private String userName;
    private String password;

    private LocalDateTime date;

    public Schedule(String userName, String password, String title, String contents) {
        this.userName = userName;
        this.password = password;
        this.title = title;
        this.contents = contents;
        this.date = LocalDateTime.now();
    }

    public void update(String userName, String title, String contents){
        this.userName = userName;
        this.title = title;
        this.contents = contents;
    }

}
