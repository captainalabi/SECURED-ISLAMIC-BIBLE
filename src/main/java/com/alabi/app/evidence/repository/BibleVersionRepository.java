package com.alabi.app.evidence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alabi.app.evidence.entity.BibleVersion;

@Repository
public interface BibleVersionRepository extends JpaRepository<BibleVersion, Integer> {

}
