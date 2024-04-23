package com.example.librarymanagement.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberRequest {
    private String name;

    private String email;

    private String memberId;
    
}
