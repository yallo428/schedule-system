package org.example.schedulemanagement.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.example.schedulemanagement.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScheduleRepository {

    private final EntityManager em;

    public void save(Schedule schedule){
        em.persist(schedule);
    }

    public Schedule findOne(Long id){
        return em.find(Schedule.class, id);
    }

    public List<Schedule> findAll(){
        return em.createQuery("select s from Schedule s order by date desc", Schedule.class)
             .getResultList();
    }

    public void delete(Schedule schedule){
        em.remove(schedule);
    }
}
