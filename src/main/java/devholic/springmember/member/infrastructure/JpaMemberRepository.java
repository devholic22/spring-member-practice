package devholic.springmember.member.infrastructure;

import devholic.springmember.member.domain.Member;
import devholic.springmember.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class JpaMemberRepository implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member save(final Member member) {
        return memberJpaRepository.save(member);
    }

    @Override
    public Optional<Member> findMemberById(final Long memberId) {
        return memberJpaRepository.findById(memberId);
    }
}
