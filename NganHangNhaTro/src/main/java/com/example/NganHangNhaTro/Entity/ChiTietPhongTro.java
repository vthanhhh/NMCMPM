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
@Table(name="tblChiTietPhongTro")
public class ChiTietPhongTro {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name="PK_sMaChiTietPhong")
    private UUID MaChiTietPhong;


    @Column(name="bTrangThaiDuyet")
    private boolean TrangThaiDuyet;
}
