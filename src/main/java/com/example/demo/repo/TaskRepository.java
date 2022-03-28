package com.example.demo.repo;


import com.example.demo.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task,Long> {

     List<Task> findAllByProjectId(Long project_id);

}
