package com.example.NganHangNhaTro.Repository;

import com.example.NganHangNhaTro.Entity.VaiTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VaiTroRepository extends JpaRepository<VaiTro, Integer> {
    Optional<VaiTro> findByTenVaiTro(String name);

}
