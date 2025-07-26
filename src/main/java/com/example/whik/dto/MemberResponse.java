package com.example.whik.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record MemberResponse(UUID memberId) {

    public static MemberResponse of(UUID memberId) {
        return new MemberResponse(memberId);
    }
}
