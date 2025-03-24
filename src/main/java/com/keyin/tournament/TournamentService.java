package com.keyin.tournament;

import com.keyin.member.Member;
import com.keyin.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Tournament addTournament(TournamentDTO tournamentDTO) {
        Tournament tournament = new Tournament();
        tournament.setStartDate(tournamentDTO.getStartDate());
        tournament.setEndDate(tournamentDTO.getEndDate());
        tournament.setLocation(tournamentDTO.getLocation());

        // Convert entry fee and cash prize to BigDecimal if they are double in DTO
        tournament.setEntryFee(BigDecimal.valueOf(tournamentDTO.getEntryFee()));
        tournament.setCashPrize(BigDecimal.valueOf(tournamentDTO.getCashPrize()));


        Set<Member> members = new HashSet<>(memberRepository.findAllById(tournamentDTO.getMemberIds()));
        tournament.setParticipatingMembers(members);

        return tournamentRepository.save(tournament);
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }
}
