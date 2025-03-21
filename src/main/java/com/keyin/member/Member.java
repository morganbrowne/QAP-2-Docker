package com.keyin.member;

import com.keyin.tournament.Tournament;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String email;
    private String phone;
    private LocalDate startDate;
    private int membershipDuration;

    @ManyToMany(mappedBy = "participants")
    private List<Tournament> tournaments;
}
