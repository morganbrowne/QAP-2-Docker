package com.keyin.member;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberDTO {
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private LocalDate startDate;
    private int durationInMonths;
}

