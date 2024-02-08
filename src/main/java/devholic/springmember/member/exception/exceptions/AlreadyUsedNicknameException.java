package devholic.springmember.member.exception.exceptions;

public class AlreadyUsedNicknameException extends RuntimeException {

    public AlreadyUsedNicknameException() {
        super("이미 사용중인 닉네임 입니다.");
    }
}
