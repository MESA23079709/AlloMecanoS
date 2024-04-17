package com.alibou.security.auth;

import com.alibou.security.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest  {



  private String  nom;

  private String adresseDomicile;

  private String ville;

  private String province;

  private String codePostal;

  private Long numeroDeCellulaire;


  private String email;

  private String password;
  private String roleUser;
  private String genre;


}
