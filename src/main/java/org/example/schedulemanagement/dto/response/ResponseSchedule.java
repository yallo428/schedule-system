package org.example.schedulemanagement.dto.response;


import lombok.Getter;
import lombok.Setter;
import org.example.schedulemanagement.entity.Schedule;

@Setter
@Getter
public class ResponseSchedule {
    private String userName;
    private String title;
    private String contents;

    public ResponseSchedule(Schedule schedule) {
        this.userName = schedule.getUserName();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
    }
}
