package com.keyin.tournament;


import com.keyin.member.Member;
import com.keyin.member.MemberRepository;
import com.keyin.tournament.TournamentDTO;
import com.keyin.tournament.Tournament;
import com.keyin.tournament.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        tournament.setEntryFee(tournamentDTO.getEntryFee());
        tournament.setCashPrize(tournamentDTO.getCashPrize());

        Set<Member> members = new HashSet<>(memberRepository.findAllById(tournamentDTO.getMemberIds()));
        tournament.setParticipatingMembers(members);

        return tournamentRepository.save(tournament);
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }
}

