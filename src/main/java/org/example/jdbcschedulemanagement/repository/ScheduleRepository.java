package org.example.jdbcschedulemanagement.repository;

import lombok.RequiredArgsConstructor;
import org.example.jdbcschedulemanagement.dto.ScheduleResponseDTO;
import org.example.jdbcschedulemanagement.dto.UpdateScheduleDTO;
import org.example.jdbcschedulemanagement.model.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public void save(Schedule schedule){
        String sql = "INSERT INTO schedule (user_name, password, title, contents, date) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql,
                schedule.getUserName(),
                schedule.getPassword(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getDate());
    }

    public List<ScheduleResponseDTO> findAll(){
        String sql = "select * from schedule order by date desc";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            String userName = rs.getString("user_name");
            String password = rs.getString("password");
            String title = rs.getString("title");
            String contents = rs.getString("contents");
            LocalDateTime date = rs.getTimestamp("date").toLocalDateTime();
            return new ScheduleResponseDTO(userName, password, title, contents, date);
        });
    }


    public ScheduleResponseDTO update(Long id, UpdateScheduleDTO dto){
        String sql = "update schedule set title = ?, contents = ?, user_name = ? where schedule_id = ?";

        jdbcTemplate.update(sql,
                dto.getTitle(),
                dto.getContents(),
                dto.getUserName(),
                id);

        return getScheduleDTO(id);
    }

    public void delete(Long id){
        String sql = "delete from schedule where schedule_id = " + id;
        jdbcTemplate.update(sql);
    }

    private ScheduleResponseDTO getScheduleDTO(Long id){
        String sql = "select * from schedule where schedule_id = " + id;
        jdbcTemplate.query(sql, (rs, rowNum) -> {
            String userName = rs.getString("user_name");
            String password = rs.getString("password");
            String title = rs.getString("title");
            String contents = rs.getString("contents");
            LocalDateTime date = rs.getTimestamp("date").toLocalDateTime();
            return new ScheduleResponseDTO(userName, password, title, contents, date);
        });
        return null;
    }
}
