package com.journal.Application.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.journal.Application.Repository.JournalEntryRepository;
import com.journal.Application.entity.JournalEntry;
import com.journal.Application.entity.User;
@Component
public class JournalEntryService {
	
	@Autowired
	private JournalEntryRepository journalEntryrepository ;
	
	@Autowired
	private UserService userService;
	@Transactional
	public void saveEntry(JournalEntry journalEntry, String userName) {
		try {
		User user= userService.findByUsername(userName);
		journalEntry.setDate(LocalDateTime.now());
		JournalEntry saved=journalEntryrepository.save(journalEntry);
		user.getJournalEntries().add(saved);
		userService.saveEntry(user);
		}
		catch(Exception e){
			System.out.print(e);
			throw new RuntimeException("An error occured while sqving the entry.",e);
		}
	}
	public void saveEntry(JournalEntry journalEntry) {
		journalEntryrepository.save(journalEntry);
	}
	public List<JournalEntry> getAll(){
		return journalEntryrepository.findAll();
	}
	public Optional<JournalEntry> findById(ObjectId id) { 
		return journalEntryrepository.findById(id);
	}
 public void deleteById(ObjectId id, String userName) {
		User user= userService.findByUsername(userName);
		user.getJournalEntries().removeIf(x->x.getId().equals(id));
		userService.saveEntry(user);
	    journalEntryrepository.deleteById(id);
}
}
