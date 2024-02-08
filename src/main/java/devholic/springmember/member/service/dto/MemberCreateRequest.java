package devholic.springmember.member.service.dto;

import jakarta.validation.constraints.NotBlank;

public record MemberCreateRequest (

        @NotBlank(message = "이름이 필요합니다.")
        String username,

        @NotBlank(message = "닉네임이 필요합니다.")
        String nickname,

        @NotBlank(message = "비밀번호가 필요합니다.")
        String password){
}
