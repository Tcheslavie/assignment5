package ac.za.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping(value = {"/", "/index"})
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Welcome to E-Voting App!", HttpStatus.OK);
    }
}
