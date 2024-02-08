package devholic.springmember.member.service;

import devholic.springmember.member.domain.Member;
import devholic.springmember.member.domain.MemberAuth;
import devholic.springmember.member.domain.MemberRepository;
import devholic.springmember.member.service.dto.MemberCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final MemberRepository memberRepository;

    public Long signup(final MemberCreateRequest request) {
        MemberAuth memberAuth = new MemberAuth(request.nickname(), request.password());
        Member newMember = new Member(request.username(), memberAuth);
        Member createMember = memberRepository.save(newMember);

        return createMember.getId();
    }
}
