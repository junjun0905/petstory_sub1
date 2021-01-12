package com.web.curation.controller.account;

import java.util.Optional;

import javax.validation.Valid;

import com.web.curation.dao.user.UserDao;
import com.web.curation.model.BasicResponse;
import com.web.curation.model.user.SignupRequest;
import com.web.curation.model.user.User;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@ApiResponses(value = { @ApiResponse(code = 401, message = "Unauthorized", response = BasicResponse.class),
        @ApiResponse(code = 403, message = "Forbidden", response = BasicResponse.class),
        @ApiResponse(code = 404, message = "Not Found", response = BasicResponse.class),
        @ApiResponse(code = 500, message = "Failure", response = BasicResponse.class) })

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class AccountController {

    @Autowired
    UserDao userDao;

    @GetMapping("/account/login") //리소스 조회
    @ApiOperation(value = "로그인") // @ApiOperation 위 URL과 매핑, 문서화 대상 처리 됨

    public Object login(@RequestParam(required = true) final String email,
            @RequestParam(required = true) final String password) {

        Optional<User> userOpt = userDao.findUserByEmailAndPassword(email, password);
        // optional이 머냐 -> User 타입객체 포장해주는 래퍼 클래스
        // 여기서 DAO 가고 매퍼 안쓰고 JPA 적용했구나
        // 어케쓰는거지? -> 인프런으로 공부

        ResponseEntity response = null;

        if (userOpt.isPresent()) {
            final BasicResponse result = new BasicResponse();
            result.status = true;
            result.data = "success";
            response = new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @PostMapping("/account/signup") //리소스 생성
    @ApiOperation(value = "가입하기")

    public Object signup(@Valid @RequestBody SignupRequest request) {
        // 이전 dto 객체처럼 받네 --- SignupRequest


        // 이메일, 닉네임 중복처리 필수   --> 이전에는 메퍼에서 쿼리문 쓰고 중복여부 리턴 받았는데?   --> 이제는 JPA에서 리턴 받나보다
        // 회원가입단을 생성해 보세요.

        final BasicResponse result = new BasicResponse();
        result.status = true;
        result.data = "success";

        //IF문으로 HttpStatus 상테 구분해서 처리하자
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}