package com.example.whik.repository;

import com.example.whik.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    boolean existsByNickname(String nickname);

}
