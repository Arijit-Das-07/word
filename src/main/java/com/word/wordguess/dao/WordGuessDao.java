package com.word.wordguess.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.word.wordguess.entity.WordGuess;

@Repository
public interface WordGuessDao extends JpaRepository<WordGuess, Long> {
	
	Optional<WordGuess> findById(Long id);

	void save(Optional<WordGuess> wordGuess);
}
