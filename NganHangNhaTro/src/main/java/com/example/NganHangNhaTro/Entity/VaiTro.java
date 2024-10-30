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
@Table (name="tblVaiTro")
public class VaiTro {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name="PK_sMaVaiTro")
    private String MaVaiTro;

    @Column(name="sTenVaiTro")
    private String TenVaiTro;
}
