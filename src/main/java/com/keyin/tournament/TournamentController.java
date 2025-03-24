package com.keyin.tournament;


import com.keyin.tournament.TournamentDTO;
import com.keyin.tournament.Tournament;
import com.keyin.tournament.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/add")
    public Tournament addTournament(@RequestBody TournamentDTO tournamentDTO) {
        return tournamentService.addTournament(tournamentDTO);
    }

    @GetMapping("/all")
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }
}

