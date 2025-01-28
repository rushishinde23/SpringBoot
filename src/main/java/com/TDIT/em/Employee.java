package com.TDIT.em;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
   @Id
   private Long id;
   private String name;
   private String city;
   private  String email;

   public Employee() {
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   @Override
   public String toString() {
      return "Employee{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", city='" + city + '\'' +
              ", email='" + email + '\'' +
              '}';
   }
}
