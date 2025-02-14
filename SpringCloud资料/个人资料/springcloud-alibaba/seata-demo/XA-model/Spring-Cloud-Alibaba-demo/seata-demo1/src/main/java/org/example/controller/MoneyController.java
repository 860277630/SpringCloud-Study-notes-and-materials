package org.example.controller;

import org.example.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("money")
public class MoneyController {

    @Autowired
    private TransService transService;

    @RequestMapping("test/globalTransactional/fail")
    public ResponseEntity<String> testGTRollBack() {
        transService.globalRollBackDemo(60);
        return new ResponseEntity<String>("sucess",HttpStatus.OK);
    }

    @RequestMapping("test/globalTransactional/sucess")
    public ResponseEntity<String> testGTSucess() {
        transService.globalRollBackDemo(40);
        return new ResponseEntity<String>("sucess",HttpStatus.OK);
    }


}
