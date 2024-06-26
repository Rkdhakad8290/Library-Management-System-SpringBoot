package com.Library.Management.Systems.Controller;

import com.Library.Management.Systems.Entities.LibraryCard;
import com.Library.Management.Systems.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/generatePlainCard")
    public ResponseEntity generatePlainCard(){


        //CardNo : autogenrated

        //cardStatus : New

        //with which student to associate : I will create a Saprate API

        LibraryCard newCard = cardService.generatedCard();

        String response = "The card is generated and having a cardNo "+newCard.getCardNo();

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/associateWithStudent")
    public ResponseEntity associateWithStudent(@RequestParam("studentId")Integer studentId,@RequestParam("cardId")Integer cardNo){

        String result = cardService.associateStudentWithCard(studentId,cardNo);

        return new ResponseEntity(result,HttpStatus.OK);
    }
}
