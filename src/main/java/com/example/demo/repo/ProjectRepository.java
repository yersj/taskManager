package com.example.demo.repo;

import com.example.demo.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findByOrderByStartAsc();
}
