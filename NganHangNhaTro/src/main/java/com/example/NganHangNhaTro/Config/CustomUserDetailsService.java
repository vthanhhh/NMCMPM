package com.example.NganHangNhaTro.Config;

import com.example.NganHangNhaTro.Entity.TaiKhoan;
import com.example.NganHangNhaTro.Repository.TaiKhoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Set;
import java.util.stream.Collectors;
@Configuration
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final TaiKhoanRepository taiKhoanRepository;

    @Override
    public UserDetails loadUserByUsername(String taikhoan) throws UsernameNotFoundException {
        TaiKhoan theTaiKhoan = taiKhoanRepository.findByTaiKhoan(taikhoan).orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
        Set<GrantedAuthority> grantedAuthorities = theTaiKhoan.getVaitros().stream()
                .map((VaiTro)->new SimpleGrantedAuthority(VaiTro.getTenVaiTro()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                taikhoan,
                theTaiKhoan.getMatKhau(),
                grantedAuthorities
        );
    }
}



