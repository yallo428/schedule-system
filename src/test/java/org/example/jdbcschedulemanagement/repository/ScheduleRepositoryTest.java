package org.example.jdbcschedulemanagement.repository;

import org.example.jdbcschedulemanagement.dto.ScheduleResponseDTO;
import org.example.jdbcschedulemanagement.dto.UpdateScheduleDTO;
import org.example.jdbcschedulemanagement.model.Schedule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScheduleRepositoryTest {

    @Autowired
    ScheduleRepository scheduleRepository;


    @Test
    void 저장(){
        Schedule schedule = new Schedule("ttt",
                "1234",
                "test",
                "테스트중"
                );

        scheduleRepository.save(schedule);
    }

    @Test
    void 조회(){
        List<ScheduleResponseDTO> dtos = scheduleRepository.findAll();

        for (ScheduleResponseDTO dto : dtos) {
            System.out.println(dto.getContents());
        }
    }

    @Test
    void 업데이트(){
        UpdateScheduleDTO updateScheduleDTO = new UpdateScheduleDTO("변경", "변경", "변경");
        ScheduleResponseDTO update = scheduleRepository.update(1L, updateScheduleDTO);
    }
    @Test
    void 삭제(){
        scheduleRepository.delete(1L);
    }

}