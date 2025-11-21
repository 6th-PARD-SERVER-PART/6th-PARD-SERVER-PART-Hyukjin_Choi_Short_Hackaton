package com.pard.server.domdry.repository;

import com.pard.server.domdry.domain.Member;
import com.pard.server.domdry.domain.PickUpSchedulePlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PickUpSchedulePlaceRepository extends JpaRepository<PickUpSchedulePlace, Long> {
}
