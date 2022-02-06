package com.word.wordguess.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.word.wordguess.dto.WordGuessDto;

@Service
public interface WordGuessService {

	WordGuessDto getWordById(Long id);

	WordGuessDto addWord(WordGuessDto word);

	String addWords(List<String> word);

	WordGuessDto getTodaysWord();

}
