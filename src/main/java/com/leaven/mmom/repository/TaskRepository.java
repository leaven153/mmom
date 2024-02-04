package com.leaven.mmom.repository;

import com.leaven.mmom.entity.MmomTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<MmomTask, Long> {
}
