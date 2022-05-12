package com.cqupt.dto;

import com.cqupt.mbg.model.UmsAdmin;
import com.cqupt.mbg.model.UmsPermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jingdong
 * @description: SpringSecurity需要的用户详情
 * @menu
 * @date 2022/5/11 21:35
 */
public class AdminUserDetails implements UserDetails {

    private UmsAdmin umsAdmin;
    private List<UmsPermission> permissionsList;
    public AdminUserDetails(UmsAdmin umsAdmin, List<UmsPermission> permissionsList){
        this.umsAdmin = umsAdmin;
        this.permissionsList = permissionsList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /**
         * 返回当前用户的权限
         */
        return permissionsList.stream()
                .filter(permission -> permission.getValue()!= null)
                .map(permission -> new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
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
        return umsAdmin.getStatus().equals(1);
    }
}
