package kr.codesquad.sidedish;

import kr.codesquad.sidedish.response.CommonCode;
import kr.codesquad.sidedish.exception.CustomException;
import kr.codesquad.sidedish.response.ErrorCode;
import kr.codesquad.sidedish.response.BasicResponse;
import kr.codesquad.sidedish.response.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public ResponseEntity<? extends BasicResponse> getTest() {
        return new CommonResponse<Void>(CommonCode.SUCCESS).toResponseEntity();
    }

    @GetMapping("/test")
    public String getTest2() {
        throw new CustomException(ErrorCode.INVALID_REQUEST_PARAMETER);
    }
}
