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
        return scheduleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ResponseSchedule find(Long id){
        return scheduleRepository.findOne(id);
    }

    public void save(CreateRequestSchedule dto) {
        Schedule schedule = new Schedule(
                dto.getUserName(),
                dto.getPassword(),
                dto.getTitle(),
                dto.getContents());
        scheduleRepository.save(schedule);
    }


    public ResponseSchedule update(Long id, UpdateRequestSchedule requestDTO) {
        Schedule schedule = scheduleRepository.findOne(id);
        EntityNullCheck(schedule);
        schedule.update(requestDTO.getUserName(), requestDTO.getTitle(), requestDTO.getContents());

        return new ResponseSchedule(schedule);
    }

    public void delete(Long scheduleId, String password) {
        String userPassword = scheduleRepository.findPassword(scheduleId);

        if (password.equals(userPassword)) {
            scheduleRepository.delete(scheduleId);
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
