package com.example.NganHangNhaTro.Helper;

import com.example.NganHangNhaTro.Entity.TaiKhoan;
import com.example.NganHangNhaTro.Repository.TaiKhoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthHelper {
    private final TaiKhoanRepository taiKhoanRepository;
    public TaiKhoan getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {

            Object principal = authentication.getPrincipal();
            if (principal instanceof org.springframework.security.core.userdetails.User) {
                UserDetails userDetails = ( org.springframework.security.core.userdetails.User) principal;
                String username = userDetails.getUsername();

                TaiKhoan userFromDb = taiKhoanRepository.findByTaiKhoan(username)
                        .orElseThrow(() -> new RuntimeException("User not found in the database"));

                return taiKhoanRepository.findById(userFromDb.getMaTaiKhoan())
                        .orElseThrow(() -> new RuntimeException("Person not found for the authenticated user"));
            }
        }

        throw new RuntimeException("User is not authenticated or principal is not User");
    }
}
