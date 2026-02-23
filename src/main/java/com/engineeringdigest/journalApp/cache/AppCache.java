package com.engineeringdigest.journalApp.cache;

import com.engineeringdigest.journalApp.entity.ConfigJournalAppEntity;
import com.engineeringdigest.journalApp.repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public enum keys{
        //it is using when multiple api uses on our project
        WEATHER_KEY;
    }

    public Map<String , String > appCache ;//when bean formed then all the key value are load in appCache
    
    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    @PostConstruct
    public void init(){
        appCache = new HashMap<>();
        List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();
        for(ConfigJournalAppEntity configJournalAppEntity:all){
            appCache.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
        }

    }
}
