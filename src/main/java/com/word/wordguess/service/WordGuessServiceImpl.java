package com.word.wordguess.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.word.wordguess.dao.WordGuessDao;
import com.word.wordguess.dto.WordGuessDto;
import com.word.wordguess.entity.WordGuess;



@Service
public class WordGuessServiceImpl implements WordGuessService {
	
	@Autowired
	private WordGuessDao wordDetailsDao;
	
	@Override
	public WordGuessDto addWord(WordGuessDto word)
	{
		WordGuess wordGuess = new WordGuess();
		BeanUtils.copyProperties(word,wordGuess);
		wordDetailsDao.save(wordGuess);
		WordGuessDto wordDto = new WordGuessDto();
		BeanUtils.copyProperties(wordGuess, wordDto);
		return wordDto;	
	}
	
	public WordGuessDto getWordById(Long id)
	{
		Optional<WordGuess> wordGuess = wordDetailsDao.findById(id);
		WordGuess wordDetails = wordGuess.get();
		WordGuessDto wordDto = new WordGuessDto();
		BeanUtils.copyProperties(wordDetails, wordDto);
		return wordDto;		
	}
	
}
