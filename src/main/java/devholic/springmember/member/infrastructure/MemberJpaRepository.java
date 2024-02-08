package devholic.springmember.member.infrastructure;

import devholic.springmember.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}
