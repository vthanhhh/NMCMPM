package com.example.NganHangNhaTro.Service.Interface;

import com.example.NganHangNhaTro.Dto.DangKyDTO;
import com.example.NganHangNhaTro.Dto.DangNhapDTO;

public interface AuthService {
    String DangNhap(DangNhapDTO dangnhapDTO);
    String DangKy(DangKyDTO dangkyDTO);
}
