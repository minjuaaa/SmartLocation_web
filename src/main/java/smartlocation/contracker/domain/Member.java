package smartlocation.contracker.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long memberId;
    private String memberName;
    private String memberPhoneNumber;

    public Member() {
    }

    public Member(String memberName, String memberPhoneNumber) {
        this.memberName = memberName;
        this.memberPhoneNumber = memberPhoneNumber;
    }

    public Member(Long memberId, String memberName, String memberPhoneNumber) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPhoneNumber = memberPhoneNumber;
    }
}
