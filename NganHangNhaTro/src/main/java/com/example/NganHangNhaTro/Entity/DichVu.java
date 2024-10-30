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
@Table (name="tblDichVu")
public class DichVu {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name="PK_sMaDichVu")
    private String MaDichVu;

    @Column (name="sTenDichVu")
    private String TenDichVu;
}
