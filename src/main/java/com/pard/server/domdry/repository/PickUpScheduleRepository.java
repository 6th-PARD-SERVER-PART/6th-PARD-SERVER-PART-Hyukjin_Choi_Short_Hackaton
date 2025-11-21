package com.pard.server.domdry.repository;

import com.pard.server.domdry.domain.Member;
import com.pard.server.domdry.domain.PickUpSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PickUpScheduleRepository extends JpaRepository<PickUpSchedule, Long> {
}
