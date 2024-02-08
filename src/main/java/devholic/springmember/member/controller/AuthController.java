package devholic.springmember.member.controller;

import devholic.springmember.member.controller.dto.MemberCreateResponse;
import devholic.springmember.member.service.AuthService;
import devholic.springmember.member.service.dto.MemberCreateRequest;
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

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberCreateResponse> createMember(@RequestBody @Valid final MemberCreateRequest request) {
        Long memberId = authService.signup(request);
        return ResponseEntity.ok()
                .body(new MemberCreateResponse(memberId));
    }
}
