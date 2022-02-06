package com.word.wordguess.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="word_today")
public class WordToday {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable= false,name="id")
	private Long id;
	
	@Column(nullable = false,name="word",unique=true)
	private String word;
	
	@Column(nullable = false,name="wordid",unique=true)
	private Long wordId;
	
	@Column(nullable = false,name="today",unique=true)
	private LocalDate today = java.time.LocalDate.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Long getWordId() {
		return wordId;
	}

	public void setWordId(Long wordId) {
		this.wordId = wordId;
	}

	public LocalDate getDate() {
		return today;
	}

	public void setDate(LocalDate date) {
		this.today = date;
	}
	
	
}
