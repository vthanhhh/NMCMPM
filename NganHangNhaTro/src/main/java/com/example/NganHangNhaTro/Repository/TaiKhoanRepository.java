package com.example.NganHangNhaTro.Repository;

import com.example.NganHangNhaTro.Entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
    Optional<TaiKhoan> findByTaiKhoan(String taikhoan);
    boolean existsByTaiKhoan(String taikhoan);
    Optional<TaiKhoan> findById(String mataikhoan);

}
