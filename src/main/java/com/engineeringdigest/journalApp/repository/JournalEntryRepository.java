package com.engineeringdigest.journalApp.repository;

import com.engineeringdigest.journalApp.entity.JournalEntry;

import org.springframework.data.mongodb.repository.MongoRepository;

//Usually interface class can't require to write annotation for formation of bean

public interface JournalEntryRepository extends MongoRepository< JournalEntry , String> {
}
