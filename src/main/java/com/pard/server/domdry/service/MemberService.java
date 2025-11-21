package com.pard.server.domdry.service;

import com.pard.server.domdry.domain.Member;
import com.pard.server.domdry.dto.MemberCreateRequest;
import com.pard.server.domdry.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void create(MemberCreateRequest request){
        validateDuplicatedMember(request.getName(), request.getPhoneNumber());

        Member member = request.toEntity();

        memberRepository.save(member);
    }

    private void validateDuplicatedMember(String name, String phoneNumber){
        if(memberRepository.existsByName(name)) {
            throw new RuntimeException("duplicated Member");
        }
        if(memberRepository.existsByPhoneNumber(phoneNumber)) {
            throw new RuntimeException("duplicated Member");
        }
    }
}
