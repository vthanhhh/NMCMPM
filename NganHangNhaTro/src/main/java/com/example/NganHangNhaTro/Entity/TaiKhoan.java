package com.example.NganHangNhaTro.Entity;

import com.example.NganHangNhaTro.Dto.DangKyDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tblTaiKhoan")
public class TaiKhoan {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name="PK_sMaTaiKhoan")
    private String  MaTaiKhoan;
    @Column(name="sTaiKhoan", unique = true)
    private String TaiKhoan;
    @Column(name="sMatKhau")
    private String MatKhau;
    @Column(name="sTenNguoiDung")
    private String TenNguoiDung;
    @Column(name="sSDT", unique = true)
    private String SDT;
    @Column(name="sCCCD", unique = true)
    private String CCCD;
    @Column(name="sEmail", unique = true)
    private String Email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tblTaiKhoanVaiTro",
            joinColumns = @JoinColumn(name = "FK_sMaTaiKhoan", referencedColumnName = "PK_sMaTaiKhoan"),
            inverseJoinColumns = @JoinColumn(name = "FK_sMaVaiTro", referencedColumnName = "PK_sMaVaiTro")
    )
    private Set<VaiTro> vaitros = new HashSet<>();

    public static TaiKhoan fromRegisterDto(DangKyDTO dangkyDTO) {
        TaiKhoan taikhoan = new TaiKhoan();
        taikhoan.setTaiKhoan(dangkyDTO.getTaikhoan());
        taikhoan.setMatKhau(dangkyDTO.getMatkhau());
        /*taikhoan.setTenNguoiDung(dangkyDTO.getTennguoidung());
        taikhoan.setSDT(dangkyDTO.getSdt());
        taikhoan.setCCCD(dangkyDTO.getCccd());
        taikhoan.setEmail(dangkyDTO.getEmail());*/
        return taikhoan;
    }

    public void withRole(VaiTro vaitro){
        this.vaitros.add(vaitro);
    }
}
