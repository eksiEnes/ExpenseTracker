package com.enes.expensetracker.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "transactions")
public class Transaction extends BaseEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="description")
    private String description;

    @Column(name="amount")
    private BigDecimal amount; // Harcama miktarı

    // Kullanıcı ile ilişkilendirilen foreign key
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
