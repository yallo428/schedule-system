package org.example.schedulemanagement.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.example.schedulemanagement.dto.response.ResponseSchedule;
import org.example.schedulemanagement.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScheduleRepository {

    private final EntityManager em;

    public void save(Schedule schedule) {
        em.persist(schedule);
    }

    public Schedule findOne(Long id) {
        return em.find(Schedule.class, id);
    }

    public List<ResponseSchedule> findAll() {
        return em.createQuery("select s from Schedule s order by date desc", Schedule.class)
                .getResultList().stream().map(ResponseSchedule::new).toList();
    }

    public void delete(Long id) {
        em.remove(id);
    }

    public String findPassword(Long id) {
        return em.find(Schedule.class, id).getPassword();
    }
}
