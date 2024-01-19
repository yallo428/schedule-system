package org.example.schedulemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.exception.PasswordMatchException;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
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

    public void update(String userName, String password, String title, String contents){
        if(!isPasswordMatch(password)){
            throw new PasswordMatchException();
        }
        this.userName = userName;
        this.password = password;
        this.title = title;
        this.contents = contents;
    }

    public boolean isPasswordMatch(String password){
        return this.password.equals(password);
    }
}
