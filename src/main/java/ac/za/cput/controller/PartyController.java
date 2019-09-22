package ac.za.cput.controller;

import ac.za.cput.domain.*;
import ac.za.cput.factory.PartyFactory;
import ac.za.cput.service.CandidatePartyService;
import ac.za.cput.service.PartyService;
import ac.za.cput.service.UserService;
import ac.za.cput.service.impl.CandidatePartyServiceImpl;
import ac.za.cput.service.impl.CandidateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/party")
public class PartyController {
    @Autowired
    @Qualifier("PartyServiceImpl")
    private PartyService service;

    @Autowired
    private CandidatePartyServiceImpl cpService;
    @Autowired
    private CandidateServiceImpl candidateService;

    @PostMapping(value = "/create/{party}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@PathVariable String party) {
        if(party == null || party.trim().isEmpty()) {
            return new ResponseEntity("{status:\"Bad request\"}", HttpStatus.BAD_REQUEST);
        }

        Party p = service.findByName(party);
        if(p != null) {
            return new ResponseEntity("{status:\"Party already exists\"}", HttpStatus.BAD_REQUEST);
        }
        p = PartyFactory.getParty(party);
        service.create(p);
        return new ResponseEntity("{status:\"Party created\"}", HttpStatus.OK);
    }

    @GetMapping("/read/{party}")
    public ResponseEntity read(@PathVariable String party) {
        Party p = service.findByName(party);
        if(p == null) {
            return new ResponseEntity("{status: \"Party not found\"}", HttpStatus.BAD_REQUEST);
        }

        Set<CandidateParty> cp = cpService.getAll().stream().filter(c -> c.getPartyId().equals(p.getPartyId())).collect(Collectors.toSet());
        Set<Candidate> cands = new HashSet<>();
        for(CandidateParty c : cp) {
            cands.add(candidateService.read(c.getCandidateId()));
        }

        HashMap<String, Object> resp = new HashMap<>();
        resp.put("party", p);
        resp.put("candidates", cands);

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/read/all")
    public ResponseEntity getAll() {
        Set<Party> parties = service.getAll();
        return ResponseEntity.ok(parties);
    }
}
