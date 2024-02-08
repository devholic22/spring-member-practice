package devholic.springmember.member.controller;

import devholic.springmember.member.controller.dto.MemberCreateResponse;
import devholic.springmember.member.domain.Member;
import devholic.springmember.member.service.AuthService;
import devholic.springmember.member.service.dto.LoginRequest;
import devholic.springmember.member.service.dto.MemberCreateRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private static final String COOKIE_NAME = "AUTH";
    private static final int EXPIRATION_SECONDS = 60 * 60;

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberCreateResponse> createMember(@RequestBody @Valid final MemberCreateRequest request) {
        Long memberId = authService.signup(request);
        return ResponseEntity.ok()
                .body(new MemberCreateResponse(memberId));
    }

    @PostMapping("/login/cookie")
    public ResponseEntity<Void> loginWithCookie(@RequestBody @Valid final LoginRequest request,
                                                final HttpServletResponse response) {
        Member loginMember = authService.loginWithCookieAndSession(request);
        Cookie loginCookie = generateCookieByMember(loginMember);
        response.addCookie(loginCookie);

        return ResponseEntity.ok()
                .build();
    }

    private Cookie generateCookieByMember(final Member member) {
        String cookieValue = generateCookieValueByMember(member);
        Cookie cookie = new Cookie(COOKIE_NAME, cookieValue);

        cookie.setPath("/");
        cookie.setSecure(true);
        cookie.setMaxAge(EXPIRATION_SECONDS);
        cookie.setHttpOnly(true);

        return cookie;
    }

    private String generateCookieValueByMember(final Member member) {
        return member.getNickname() + "." + member.getPassword();
    }
}
