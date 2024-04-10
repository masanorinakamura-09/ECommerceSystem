package com.ec.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ec.entity.Customer;

public class CustomerDetail implements UserDetails{

    private static final long serialversionUID=1L;

    private final Customer customer;
    private final Collection<? extends GrantedAuthority> authorities;

    public CustomerDetail(Customer customer) {
        this.customer = customer;
        this.authorities = new ArrayList<GrantedAuthority>();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO 自動生成されたメソッド・スタブ
        return authorities;
    }
    public Customer getCustomer() {
        return customer;
    }
    @Override
    public String getPassword() {
        // TODO 自動生成されたメソッド・スタブ
        return customer.getAuthentication().getPassword();
    }

    @Override
    public String getUsername() {
        // TODO 自動生成されたメソッド・スタブ
        return customer.getAuthentication().getLoginUser();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO 自動生成されたメソッド・スタブ
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO 自動生成されたメソッド・スタブ
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO 自動生成されたメソッド・スタブ
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO 自動生成されたメソッド・スタブ
        return true;
    }

}
