package com.pard.server.domdry.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String phoneNumber;

    public static Member of(String name, String phoneNumber) {
        return Member.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .build();
    }
}
