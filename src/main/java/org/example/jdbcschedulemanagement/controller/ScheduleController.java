package org.example.jdbcschedulemanagement.controller;


import lombok.RequiredArgsConstructor;

import org.example.jdbcschedulemanagement.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/create")
    public ResponseEntity<String> createSchedule(@RequestBody @Valid CreateRequestSchedule createRequestSchedule) {
        scheduleService.save(createRequestSchedule);
        return new ResponseEntity<>("가입이 성공되었습니다", HttpStatus.CREATED);
    }

    @GetMapping("/create")
    public ResponseEntity<List<ResponseSchedule>> schedules() {
        List<ResponseSchedule> all = scheduleService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<ResponseSchedule> updateSchedule(@PathVariable Long id, @RequestBody @Valid UpdateRequestSchedule updateRequestSchedule) {
        ResponseSchedule update = scheduleService.update(id, updateRequestSchedule);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id, @RequestParam String password) {
        scheduleService.delete(id, password);
        return new ResponseEntity<>("삭제가 성공되었습니다", HttpStatus.OK);
    }
}
