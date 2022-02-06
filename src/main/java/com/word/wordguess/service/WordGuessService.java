package com.word.wordguess.service;

import org.springframework.stereotype.Service;

import com.word.wordguess.dto.WordGuessDto;

@Service
public interface WordGuessService {

	WordGuessDto getWordById(Long id);

	WordGuessDto addWord(WordGuessDto word);

}
