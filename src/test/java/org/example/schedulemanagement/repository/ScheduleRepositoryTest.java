package org.example.schedulemanagement.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ScheduleRepositoryTest {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Test
    @DisplayName("데이터 저장")
    @Rollback(false)
    void save() {
    }

}