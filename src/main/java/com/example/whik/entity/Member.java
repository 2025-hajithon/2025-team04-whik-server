package com.example.whik.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "member_id")
    private UUID id;

    @Column(unique = true) // unique 조건 추가
    private String nickname;

    @Builder(access = AccessLevel.PRIVATE)
    private Member(String nickname) {
        this.nickname = nickname;
    }

    public static Member create(String nickname) {
        return Member.builder()
                .nickname(nickname).build();
    }
}
