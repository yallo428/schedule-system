package org.example.jdbcschedulemanagement.service;

import lombok.RequiredArgsConstructor;
import org.example.jdbcschedulemanagement.dto.CreateScheduleDTO;
import org.example.jdbcschedulemanagement.dto.ScheduleResponseDTO;
import org.example.jdbcschedulemanagement.dto.UpdateScheduleDTO;
import org.example.jdbcschedulemanagement.model.Schedule;
import org.example.jdbcschedulemanagement.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public List<ScheduleResponseDTO> findAll() {
        return scheduleRepository.findAll();
    }

    public void save(CreateScheduleDTO dto) {
        Schedule schedule = new Schedule(
                dto.getUserName(),
                dto.getPassword(),
                dto.getTitle(),
                dto.getContents());
        scheduleRepository.save(schedule);
    }


    public ScheduleResponseDTO update(Long id, UpdateScheduleDTO dto) {
        EntityNullCheck(schedule);
        scheduleRepository.update(id, dto);
        return new ResponseSchedule(schedule);
    }

    public void delete(Long scheduleId, String password) {
        Schedule schedule = scheduleRepository.findOne(scheduleId);
        EntityNullCheck(schedule);

    }

    private void EntityNullCheck(Schedule schedule) {
        if(Objects.isNull(schedule)){
            throw new EntityValueNullCheckException();
        }
    }
}
