package com.example.NganHangNhaTro.Service.Impl;

import com.example.NganHangNhaTro.Config.JwtTokenProvider;
import com.example.NganHangNhaTro.Dto.DangKyDTO;
import com.example.NganHangNhaTro.Dto.DangNhapDTO;
import com.example.NganHangNhaTro.Entity.TaiKhoan;
import com.example.NganHangNhaTro.Entity.VaiTro;
import com.example.NganHangNhaTro.Repository.TaiKhoanRepository;
import com.example.NganHangNhaTro.Repository.VaiTroRepository;
import com.example.NganHangNhaTro.Service.Interface.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final TaiKhoanRepository taikhoanRepository;
    private final VaiTroRepository vaitroRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public String DangNhap(DangNhapDTO dangnhapDTO) {
        Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            dangnhapDTO.getTaikhoan(),
                            dangnhapDTO.getMatkhau()
                    )
            );
            String token = jwtTokenProvider.generateToken(authentication);
            return token;
    }

    @Override
    public String DangKy(DangKyDTO dangkyDTO) {
        try {
            if (taikhoanRepository.existsByTaiKhoan(dangkyDTO.getTaikhoan())) {
                throw new RuntimeException("Ten tai khoan da ton tai");
            }
            String encryptedPassword = passwordEncoder.encode(dangkyDTO.getMatkhau());
            dangkyDTO.setMatkhau(encryptedPassword);
            TaiKhoan newTaiKhoan = TaiKhoan.fromRegisterDto(dangkyDTO);
            if (dangkyDTO.getLoaitaikhoan().equals("NGUOIDUNG")) {
                newTaiKhoan.setTenNguoiDung(dangkyDTO.getTennguoidung());
                newTaiKhoan.setSDT(dangkyDTO.getSdt());
                newTaiKhoan.setCCCD(dangkyDTO.getCccd());
                newTaiKhoan.setEmail(dangkyDTO.getEmail());
                newTaiKhoan.withRole(this.findByTenVaiTro("ROLE_NGUOIDUNG"));
                this.taikhoanRepository.save(newTaiKhoan);
            } else if (dangkyDTO.getLoaitaikhoan().equals("ADMIN")) {
                newTaiKhoan.withRole(this.findByTenVaiTro("ROLE_ADMIN"));
                this.taikhoanRepository.save(newTaiKhoan);
            } else {
                throw new RuntimeException("Invalid user type");
            }
            return "User registered successfully";
        } catch (RuntimeException ex) {
            return ex.getMessage();
        } catch (Exception ex) {
            return "An unexpected error occurred";
        }
    }
    public VaiTro findByTenVaiTro(String tenvaitro){
        return vaitroRepository.findByTenVaiTro(tenvaitro)
                .orElseThrow(() -> new RuntimeException("Khong tim thay vai tro"));
    }
}
