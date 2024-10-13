package com.enes.expensetracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "transactions")
public class Transaction extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;
    private BigDecimal amount; // Harcama miktarı

    // Kullanıcı ile ilişkilendirilen foreign key
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
