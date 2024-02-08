package devholic.springmember.member.domain;

import java.util.Optional;

public interface MemberRepository {

    Member save(final Member member);
    Optional<Member> findMemberById(final Long memberId);
}
