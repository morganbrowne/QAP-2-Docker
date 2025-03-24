package com.keyin.tournament;


import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class TournamentDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private double entryFee;
    private double cashPrize;
    private Set<Long> memberIds;
}
