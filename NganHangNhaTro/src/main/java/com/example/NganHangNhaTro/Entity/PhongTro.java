package com.example.NganHangNhaTro.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name="tblPhongTro")
public class PhongTro {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name="tblPhongTro")
    private String MaPhong;

    @Column(name="sTenPhongTro")
    private String TenPhong;

    @Column(name="sDiaChi")
    private String DiaChi;

    @Column(name="fGiaThueNha")
    private float GiaThue;

    @Column(name ="fGiaDien")
    private float GiaDien;

    @Column (name="fGiaNuoc")
    private float GiaNuoc;

    @Column (name="fDienTich")
    private float DienTich;

    @Column (name="iSoNguoiO")
    private int SoNguoiO;

    @Column (name="sTrangThai")
    private boolean TrangThai;
    @Column (name="sHinhAnh")
    private String sHinhAnh;
    @ManyToOne
    @JoinColumn(name = "FK_sMaNguoiDung")
    private TaiKhoan TaiKhoan;
    @OneToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_sMaLoaiPhong")
    private LoaiPhongTro LoaiPhongTro;
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn  (name="FK_sMaDichVu")
    private List<DichVu> dichVus = new ArrayList<>();
}
