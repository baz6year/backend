package com.example.ArtGallery.model;

import com.example.ArtGallery.model.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@Table(name = "user_tb")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private int age;
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    /*@OneToOne
    @JoinColumn(name = "document_id", referencedColumnName = "id")
    private Document document;

    @OneToMany(mappedBy = "user")
    private List<MyFile> myFiles;

    @OneToOne
    @JoinColumn(name = "image", referencedColumnName = "fileName")
    private MyFile image; */
    @OneToMany(mappedBy = "buyer")
    private List<ArtPieces> purchasedArt;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.name() ));
    }
    @Override
    public String getUsername() {
        return email;
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
