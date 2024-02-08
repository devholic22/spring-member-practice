package devholic.springmember.member.exception.exceptions;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException() {
        super("회원이 존재하지 않습니다.");
    }
}
