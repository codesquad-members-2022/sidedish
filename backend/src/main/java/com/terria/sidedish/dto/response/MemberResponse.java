package com.terria.sidedish.dto.response;

import com.terria.sidedish.domain.Member;
import com.terria.sidedish.dto.auth.Provider;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
@AllArgsConstructor
public class MemberResponse {

    @ApiModelProperty(required = true, value = "회원 아이디")
    private String userId;

    @ApiModelProperty(required = true, value = "리소스 서버")
    private Provider provider;

    @ApiModelProperty(value = "회원 이메일")
    private String email;

    @ApiModelProperty(value = "회원 이름")
    private String name;

    public static MemberResponse from(Member member) {
        return new MemberResponse(member.getUserId(), member.getProvider(), member.getEmail(), member.getName());
    }

    @Override
    public String toString() {
        return "MemberResponse{" +
                "userId='" + userId + '\'' +
                ", provider=" + provider +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
