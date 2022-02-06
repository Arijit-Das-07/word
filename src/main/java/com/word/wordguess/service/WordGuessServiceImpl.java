package com.word.wordguess.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.word.wordguess.dao.WordGuessDao;
import com.word.wordguess.dao.WordTodayDao;
import com.word.wordguess.dto.WordGuessDto;
import com.word.wordguess.entity.WordGuess;
import com.word.wordguess.entity.WordToday;



@Service
public class WordGuessServiceImpl implements WordGuessService {
	
	@Autowired
	private WordGuessDao wordDetailsDao;
	@Autowired
	private WordTodayDao wordTodayDao;
	
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

	public void saveindb(WordGuess wordGuess) {
		wordDetailsDao.save(wordGuess);	
	}
	
	@Override
	public String addWords(List<String> word) {
		
		int count=0;
		for (String w : word)
		{	
			WordGuess wordGuess = new WordGuess();
			wordGuess.setWord(w);
			saveindb(wordGuess);
			System.out.println(w);
			count++;
		}
			return count+" word Added";
	}
	
	public void newWord()
	{
		
		while(wordTodayDao.findByToday(java.time.LocalDate.now()) == null)
		{	
			long id = (long) (Math.random()* 8000); 
			System.out.println(id);
			WordGuess wordGuess = wordDetailsDao.findById(id).get();
			if(wordGuess.getCount() > 0)
			{
				newWord();
			}
			else { 
				wordGuess.setCount(wordGuess.getCount()+1);
				wordDetailsDao.save(wordGuess);
				WordToday wordToday = new WordToday();
				wordToday.setDate(java.time.LocalDate.now());
				wordToday.setWord(wordGuess.getWord());
				wordToday.setWordId(wordGuess.getId());
				wordTodayDao.save(wordToday);
			}
		}
		
		
	}
	
	@Override
	public WordGuessDto getTodaysWord() {
		WordToday wordGuess = wordTodayDao.findByToday(java.time.LocalDate.now()); 
		if(wordGuess != null)
		{
		WordGuess wordDetails = wordDetailsDao.findById(wordGuess.getWordId()).get();
		WordGuessDto wordDto = new WordGuessDto();
		BeanUtils.copyProperties(wordDetails, wordDto);
		return wordDto;
		}
		else {
		newWord();
		wordGuess = wordTodayDao.findByToday(java.time.LocalDate.now()); 
		WordGuess wordDetails = wordDetailsDao.findById(wordGuess.getWordId()).get();
		WordGuessDto wordDto = new WordGuessDto();
		BeanUtils.copyProperties(wordDetails, wordDto);
		return wordDto;
		}
		}
	
}
