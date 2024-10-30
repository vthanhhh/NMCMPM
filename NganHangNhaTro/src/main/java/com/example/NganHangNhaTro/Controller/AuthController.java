package com.example.NganHangNhaTro.Controller;

import com.example.NganHangNhaTro.Dto.DangKyDTO;
import com.example.NganHangNhaTro.Dto.DangNhapDTO;
import com.example.NganHangNhaTro.Dto.JwtAuthResponse;
import com.example.NganHangNhaTro.Service.Interface.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/auth/")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("dangkytaikhoan")
    public ResponseEntity<String> register(@RequestBody DangKyDTO dangkyDTO) {
        String responseMessage = authService.DangKy(dangkyDTO);
        HttpStatus status = responseMessage.equals("Đăng ký thành công")
                ? HttpStatus.OK
                : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(responseMessage, status);
    }
    @PostMapping("dangnhap")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody DangNhapDTO dangnhapDTO) {

        try {
            String token = authService.DangNhap(dangnhapDTO);
            JwtAuthResponse authResponseDto = new JwtAuthResponse();
            authResponseDto.setAccessToken(token);
            return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new JwtAuthResponse("Kiểm tra lại tài khoản hoặc mật khẩu"));
        }
    }
}
