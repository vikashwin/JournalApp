package com.engineeringdigest.journalApp.entity;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.Date;


@Document(collection = "journal_entries")
@Data
public class JournalEntry {
//All are written in private is field
    @Id
    private String id; //ObjectId is a special type of DataType
    private String title;
    private String content;
    private LocalDateTime date;

    //We make getter and setter for all datatype that is use of input and output
    // This file is made for design the schema of database

//    public String getId(){
//        return id;
//    }
//
//    public void setId(String id){
//        this.id = id;
//    }
//
//    public String getTitle(){
//        return title;
//    }
//
//    public void setTitle(String title){
//        this.title = title;
//    }
//
//    public String getContent(){
//        return content;
//    }
//
//    public void setContent(String content){
//        this.content = content;
//    }
//
//    public LocalDateTime getDate(){
//        return date;
//    }
//
//    public void setDate(LocalDateTime date){
//        this.date = date;
//    }


}
