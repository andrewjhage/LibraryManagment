package com.example.librarymanagement.domain.user.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
public class Member {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Getter
    @Setter
    private String memberId;

    // Made custom getter below instead of using @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private Instant registrationDate;

    @Getter
    @Setter
    // Makes it easier to remove entities with references to members???
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MemberBook> books = new ArrayList<>();

    @Getter
    @Setter
    // Changed double to BigDecimal since it seems more common
    // Default to 0.00 late fees
    private BigDecimal lateFees = BigDecimal.valueOf(0);

    public String getName() {
        return this.name;
    }

    public String getDetails() {
        return "Member name: " + getName() + "; Email: " + getEmail() + "; Late fees: " + getLateFees();
    }

    public String getMemberLateFees() {
        return getName() + " has " + getLateFees().toString() + " in late fees.";
    }
}
