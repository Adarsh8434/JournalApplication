package com.journal.Application.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journal.Application.Service.JournalEntryService;
import com.journal.Application.Service.UserService;
import com.journal.Application.entity.JournalEntry;
import com.journal.Application.entity.User;
@RestController
@RequestMapping("/journal")
public class journalEntryController {
    @Autowired
	private JournalEntryService journalEntryService ;
	
    @Autowired
    private UserService userService;
    
	@GetMapping("{userName}")
	public ResponseEntity<?> getAll(@PathVariable String userName){
		
	   User user= userService.findByUsername(userName);
		List<JournalEntry> all=user.getJournalEntries();
		if(all!=null && !all.isEmpty()) return new ResponseEntity<>(all,HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}  
	@PostMapping("{userName}")
	public ResponseEntity<?> createEntry(@RequestBody JournalEntry myentry,@PathVariable String userName){
	 try {

		 journalEntryService.saveEntry(myentry,userName);
		 return new ResponseEntity<>(myentry,HttpStatus.CREATED);
		 
	 }catch(Exception e) {
		 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	 }
	}
	
	@GetMapping("id/{myId}")
	public JournalEntry GetJournal(@PathVariable ObjectId myId) {
		return journalEntryService.findById(myId).orElse(null);
	} 
	@DeleteMapping("id/{username}/{myId}")
	public boolean DeleteJournal(@PathVariable ObjectId myId,@PathVariable String username ) {
		journalEntryService.deleteById(myId,username);
		return true;
	}
	
	@PutMapping("id/{userName}/{id}")
	public ResponseEntity<?> updateEntry(@PathVariable ObjectId id,
			@PathVariable String userName,
			@RequestBody JournalEntry newEntry) {
		JournalEntry old= journalEntryService.findById(id).orElse(null);
		if(old!=null) {
		 old.setTitle(newEntry.getTitle() !=null && !newEntry.getTitle().equals("")?newEntry.getTitle():old.getTitle());
		 old.setContent(newEntry.getContent() != null && !newEntry.equals("")?newEntry.getContent():old.getContent());
		 journalEntryService.saveEntry(old);
		 return new ResponseEntity<>(old,HttpStatus.OK);
		 
		 
		}
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
