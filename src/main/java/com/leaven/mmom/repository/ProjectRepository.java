package com.leaven.mmom.repository;

import com.leaven.mmom.entity.MmomProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<MmomProject, Long> {
}
