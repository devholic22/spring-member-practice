package devholic.springmember.member.exception;

import devholic.springmember.global.exception.ExceptionResponse;
import devholic.springmember.member.exception.exceptions.AlreadyUsedNicknameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MemberExceptionHandler {

    @ExceptionHandler(AlreadyUsedNicknameException.class)
    public ResponseEntity<ExceptionResponse> alreadyUsedNicknameExceptionHandler(final AlreadyUsedNicknameException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(e.getMessage()));
    }
}
