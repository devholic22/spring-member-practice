package devholic.springmember.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Embedded
    private MemberAuth memberAuth;

    public Member(final String username, final MemberAuth memberAuth) {
        this.username = username;
        this.memberAuth = memberAuth;
    }

    public String getNickname() {
        return memberAuth.getNickname();
    }

    public String getPassword() {
        return memberAuth.getPassword();
    }
}
