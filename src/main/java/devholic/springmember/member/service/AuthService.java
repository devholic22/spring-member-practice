package devholic.springmember.member.service;

import devholic.springmember.member.domain.Member;
import devholic.springmember.member.domain.MemberAuth;
import devholic.springmember.member.domain.MemberRepository;
import devholic.springmember.member.exception.exceptions.AlreadyUsedNicknameException;
import devholic.springmember.member.service.dto.MemberCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AuthService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long signup(final MemberCreateRequest request) {
        validateIsNotUsedNickname(request.nickname());
        MemberAuth memberAuth = new MemberAuth(request.nickname(), request.password());
        Member newMember = new Member(request.username(), memberAuth);
        Member createMember = memberRepository.save(newMember);

        return createMember.getId();
    }

    private void validateIsNotUsedNickname(final String nickname) {
        memberRepository.findByNickname(nickname)
                .ifPresent(member -> {
                    throw new AlreadyUsedNicknameException();
                });
    }
}
