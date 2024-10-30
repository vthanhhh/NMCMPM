package com.example.NganHangNhaTro.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DangKyDTO {
    private String taikhoan;
    private String matkhau;
    private String tennguoidung;
    private String sdt;
    private String cccd;
    private String email;
    private String loaitaikhoan;

}
