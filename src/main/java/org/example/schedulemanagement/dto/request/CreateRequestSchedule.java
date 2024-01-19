package org.example.schedulemanagement.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRequestSchedule {
    @NotNull
    private String userName;
    @NotNull
    private String password;
    @NotNull
    private String title;
    @NotNull
    private String contents;
}
