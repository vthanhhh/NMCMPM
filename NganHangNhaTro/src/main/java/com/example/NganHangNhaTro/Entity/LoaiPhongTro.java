package com.example.NganHangNhaTro.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name="tblLoaiPhongTro")
public class LoaiPhongTro {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name="PK_sMaLoaiPhong")
    private String MaLoaiPhong;

    @Column (name="sTenPhongTro")
    private String TenPhongTro;
}
