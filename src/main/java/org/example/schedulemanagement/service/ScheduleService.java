package org.example.schedulemanagement.service;

import lombok.RequiredArgsConstructor;
import org.example.exception.EntityValueNullCheckException;
import org.example.exception.PasswordMatchException;
import org.example.schedulemanagement.entity.Schedule;
import org.example.schedulemanagement.dto.request.CreateRequestSchedule;
import org.example.schedulemanagement.dto.response.ResponseSchedule;
import org.example.schedulemanagement.dto.request.UpdateRequestSchedule;
import org.example.schedulemanagement.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional(readOnly = true)
    public List<ResponseSchedule> findAll() {
        List<Schedule> all = scheduleRepository.findAll();
        return all.stream().map(ResponseSchedule::new).toList();
    }

    public void save(CreateRequestSchedule dto) {
        Schedule schedule = new Schedule(
                dto.getUserName(),
                dto.getPassword(),
                dto.getTitle(),
                dto.getContents());
        scheduleRepository.save(schedule);
    }


    public ResponseSchedule update(Long id, UpdateRequestSchedule dto) {
        Schedule schedule = scheduleRepository.findOne(id);
        EntityNullCheck(schedule);

        schedule.update(
                dto.getUserName(),
                dto.getPassword(),
                dto.getTitle(),
                dto.getContents());

        return new ResponseSchedule(schedule);
    }

    public void delete(Long scheduleId, String password) {
        Schedule schedule = scheduleRepository.findOne(scheduleId);
        EntityNullCheck(schedule);

        if (schedule.isPasswordMatch(password)) {
            scheduleRepository.delete(schedule);
        }else{
            throw new PasswordMatchException();
        }
    }

    private void EntityNullCheck(Schedule schedule) {
        if(Objects.isNull(schedule)){
            throw new EntityValueNullCheckException();
        }
    }
}
