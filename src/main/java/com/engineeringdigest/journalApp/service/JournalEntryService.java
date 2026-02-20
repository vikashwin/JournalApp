package com.engineeringdigest.journalApp.service;

import com.engineeringdigest.journalApp.entity.User;
import com.engineeringdigest.journalApp.repository.JournalEntryRepository;
import com.engineeringdigest.journalApp.entity.JournalEntry;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class   JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;


    @Transactional
    public void saveEntry(JournalEntry journalEntry , String userName){
        try{
            User user = userService.findByUserName(userName);
            JournalEntry saveEntry = journalEntryRepository.save(journalEntry); // it can store save entry on that movement
            user.getJournalEntries().add(saveEntry);
//            user.getUserName(null);
            userService.saveEntry(user);

        }catch(Exception e){
//            System.out.println(e);
            throw new RuntimeException("An error occupied when saving the entry :" + e);
        }

    }

    public void saveEntry(JournalEntry journalEntry ){

        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){

        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(String id){
        return journalEntryRepository.findById(id);

    }

    @Transactional
    public boolean deleteById(String id , String userName){
        boolean removed = false ;
        try{
            User user = userService.findByUserName(userName);
            removed =  user.getJournalEntries().removeIf(x-> x.getId().equals(id));
            if(removed) {
                userService.saveEntry(user);
                journalEntryRepository.deleteById(id);
            }
        }catch(Exception e){
            log.error("Error",e);
            throw new RuntimeException("An error occurred while deleting the entry:", e );
        }
      return removed;
    }

    public void deleteAll(){
        journalEntryRepository.deleteAll();
    }

}
