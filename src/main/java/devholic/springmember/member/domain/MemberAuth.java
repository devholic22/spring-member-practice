package devholic.springmember.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class MemberAuth {

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    public MemberAuth(final String nickname, final String password) {
        this.nickname = nickname;
        this.password = password;
    }
}
