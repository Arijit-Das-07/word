package com.word.wordguess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.word.wordguess.dto.WordGuessDto;
import com.word.wordguess.service.WordGuessService;

@RestController
public class WordGuessDetailscontroller {

	@Autowired
	private WordGuessService wordGuessService;
	
	
	 @GetMapping("/getwordbyid/{id}")
	    public ResponseEntity<WordGuessDto> getWordById( @PathVariable Long id) {
	        return new ResponseEntity<>(this.wordGuessService.getWordById(id), HttpStatus.OK);
	    }
	 
	 @GetMapping("/gettodaysword")
	    public ResponseEntity<WordGuessDto> gettodaysword() {
	        return new ResponseEntity<>(this.wordGuessService.getTodaysWord(), HttpStatus.OK);
	    }
	 
	 @PostMapping("/addword")   
	 	public ResponseEntity<WordGuessDto> addword(@RequestBody WordGuessDto word) {
		 return new ResponseEntity<>(this.wordGuessService.addWord(word),HttpStatus.CREATED);
	    
	    }
	 
	 @PostMapping("/addwords")   
	 	public ResponseEntity<String> addwords(@RequestBody List<String> word) {
		 return new ResponseEntity<>(this.wordGuessService.addWords(word),HttpStatus.CREATED);
	    
	    }
	
	
	
}
