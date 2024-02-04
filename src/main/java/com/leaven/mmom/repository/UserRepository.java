package com.leaven.mmom.repository;

import com.leaven.mmom.entity.MmomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MmomUser, Long> {
}
