package com.example.COFFEE.Security;

import com.example.COFFEE.Entity.UserAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Data
@AllArgsConstructor
public class CustomUserDetail implements UserDetails {
    private int userId;
    private String userName;
    @JsonIgnore
    private String userPass;
    private String phone;
    private String email;
    private Boolean userStatus;
    private Collection<? extends GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    //từ thông tin user chuyển sang thông tin CustomUserDetails
public static CustomUserDetail mapUserToUserDetail(UserAccount userAccount){
    List<GrantedAuthority> listAuthorities = userAccount.getListRole().stream()//Steam = for each
            .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))//map = đối chiếu
            .collect(Collectors.toList()); // toàn hàm có làm add dữ liệu vào list

    return new CustomUserDetail(
           userAccount.getUserId(),
            userAccount.getUserName(),
            userAccount.getUserPass(),
            userAccount.getPhone(),
            userAccount.getEmail(),
            userAccount.getUserStatus(),
            listAuthorities
    );
}


    @Override
    public String getPassword() {
        return this.userPass;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
