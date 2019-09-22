package ac.za.cput.controller;

import ac.za.cput.domain.Candidate;
import ac.za.cput.domain.CandidateParty;
import ac.za.cput.domain.Party;
import ac.za.cput.factory.CandidateFactory;
import ac.za.cput.factory.CandidatePartyFactory;
import ac.za.cput.service.impl.CandidatePartyServiceImpl;
import ac.za.cput.service.impl.CandidateServiceImpl;
import ac.za.cput.service.impl.PartyServiceImpl;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateServiceImpl candidateService;

    @Autowired
    private PartyServiceImpl partyService;

    @Autowired
    private CandidatePartyServiceImpl candidatePartyService;

    @PostMapping(value = "/create/{cand}/{cand2}/{party}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@PathVariable("cand") String cand, @PathVariable("cand2") String cand2, @PathVariable("party") String party) {
        if(cand == null || cand.trim().isEmpty()) {
            return new ResponseEntity("{status:\"Bad request\"}", HttpStatus.BAD_REQUEST);
        }

        Candidate c = candidateService.findByName(cand+" "+cand2);
        if(c != null) {
            return new ResponseEntity("{status:\"Candidate already exists\"}", HttpStatus.BAD_REQUEST);
        }
        c = CandidateFactory.getCandidate(cand, cand2);

        Party p = partyService.findByName(party);
        if(p== null) {
            return new ResponseEntity("{status:\"Party does not exists\"}", HttpStatus.BAD_REQUEST);
        }

        candidateService.create(c);

        CandidateParty cp = CandidatePartyFactory.getCandidateParty(c.getCandidateId(), p.getPartyId());
        candidatePartyService.create(cp);

        return new ResponseEntity("{status:\"Candidate created\"}", HttpStatus.OK);
    }
}
