package com.pard.server.domdry.dto;

import com.pard.server.domdry.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberCreateRequest {
    private String name;
    private String phoneNumber;

    public Member toEntity(){
        return Member.of(name,phoneNumber);
    }
}
