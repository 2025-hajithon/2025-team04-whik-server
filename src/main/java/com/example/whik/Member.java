package com.example.whik;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.hibernate.validator.constraints.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue // 전략을 쓰지 않고 다음 줄에 있는 어노테이션 사용
    @JdbcTypeCode(SqlTypes.UUID) // UUID 생성 관련 어노테이션
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
