package devholic.springmember.member.infrastructure;

import devholic.springmember.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.memberAuth.nickname = :nickname")
    Optional<Member> findByNickname(final String nickname);
}
