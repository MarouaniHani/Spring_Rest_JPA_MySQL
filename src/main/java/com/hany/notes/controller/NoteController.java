package com.hany.notes.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.hany.notes.model.Note;
import com.hany.notes.services.NoteServices;

@RestController
@RequestMapping("/api")
public class NoteController {
	@Autowired
	NoteServices ns;
	
	@GetMapping("/notes")
	public ResponseEntity<List<Note>>getAllNotes()
	{
		List<Note> notes  = ns.getAllNotes();
		return new ResponseEntity<List<Note>>(notes,HttpStatus.OK);
	}
	
	@PostMapping("/notes")
	public ResponseEntity<Note> createNote(@Valid @RequestBody Note note)
	{
		Note n = ns.createNote(note);
		return new ResponseEntity<Note>(n,HttpStatus.OK);
	}	
	@GetMapping("/notes/{id}")
	public ResponseEntity<Note> getNoteById(@PathVariable(value ="id") Long noteId)
	{
		Note n = ns.getNoteById(noteId);
		return new ResponseEntity<Note>(n,HttpStatus.OK);
	}
	@PutMapping("/notes/{id}")
	public ResponseEntity<Note> updateNote(@PathVariable(value="id")Long noteId,@Valid @RequestBody Note noteDetails)
    {
    	Note n = ns.updateNote(noteId, noteDetails);
    	return new ResponseEntity<Note>(n,HttpStatus.OK);
	}
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value="id")Long noteId)
	{
		return ns.deleteNote(noteId);
	}		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
}
