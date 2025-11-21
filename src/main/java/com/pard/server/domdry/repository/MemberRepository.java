package com.pard.server.domdry.repository;

import com.pard.server.domdry.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByName(String name);

    boolean existsByPhoneNumber(String phoneNumber);
}
