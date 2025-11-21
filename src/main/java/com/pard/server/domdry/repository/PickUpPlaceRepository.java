package com.pard.server.domdry.repository;

import com.pard.server.domdry.domain.Member;
import com.pard.server.domdry.domain.PickUpPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PickUpPlaceRepository extends JpaRepository<PickUpPlace, Long> {
}
