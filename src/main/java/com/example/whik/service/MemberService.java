package com.example.whik.service;

import com.example.whik.dto.MemberResponse;
import com.example.whik.entity.Member;
import com.example.whik.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse createMember(String nickname) {
        boolean existsByNickname = memberRepository.existsByNickname(nickname);
        if (!existsByNickname) {
            Member member = Member.create(nickname);
            memberRepository.save(member);
            return new MemberResponse(member.getId());
        }

        throw new IllegalArgumentException("nickname already exists");
    }
}
