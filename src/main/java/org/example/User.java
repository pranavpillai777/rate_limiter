package org.example;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {
    private String name;
    private String age;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
}
