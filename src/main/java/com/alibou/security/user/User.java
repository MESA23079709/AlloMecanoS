package com.alibou.security.user;

import com.alibou.security.token.Token;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user",
        uniqueConstraints = {@UniqueConstraint(name = "user_email_unique",columnNames = "adresse_email")})

public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id",
          updatable = true,
          nullable = false)
  private Integer id;
  @Column(name = "nom",
          nullable = false)
  private String  nom;
  @Column(name = "adresse_domicile",
          nullable = false)
  private String adresseDomicile;
  @Column(name = "ville",
          nullable = false)
  private String ville;
  @Column(name = "province")
  private String province;
  @Column(name = "code_postal",
          nullable = false)
  private String codePostal;
  @Column(name = "numero_de_cellulaire",
          nullable = false)
  private Long numeroDeCellulaire;
  @Column(name = "adresse_email",
          nullable = false
  )
  private String email;

  @Column(name = "mot_de_passe",
          nullable = false
  )
  private String password;


  @Column(name = "role"

  )
  private String roleUser;
  @Column(name = "genre")
  private String  genre;

  //@Enumerated(EnumType.STRING)

 // private Role role;



  @OneToMany(mappedBy = "user")
  private List<Token> tokens;

//  @Override
//  public Collection<? extends GrantedAuthority> getAuthorities() {
//    return role.getAuthorities();
//  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  //  @Override
//  public Collection<? extends GrantedAuthority> getAuthorities() {
//    return List.of(new SimpleGrantedAuthority(role));
//  }
  @Override
  public String getPassword() {
    return password;
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
