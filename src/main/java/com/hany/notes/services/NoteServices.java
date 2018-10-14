package com.hany.notes.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.hany.notes.exception.ResourceNotFoundException;
import com.hany.notes.model.Note;
import com.hany.notes.repository.NoteRepository;

public class NoteServices implements INoteServices{

	@Autowired
	NoteRepository noteRepository;
	
	// Get All Notes
		public List<Note> getAllNotes()
		{
			return noteRepository.findAll();
		}
	    // Create a new Note
		public Note createNote(@Valid @RequestBody Note note)
		{
			return noteRepository.save(note);
		}

	    // Get a Single Note
		public Note getNoteById(@PathVariable(value ="id") Long noteId)
		{
			return noteRepository.findById(noteId)
					.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
		}
		

	    // Update a Note
		//@PutMapping("/notes/{id}")
		public Note updateNote(@PathVariable(value="id")Long noteId,@Valid @RequestBody Note noteDetails)
	    {
	    	Note note = noteRepository.findById(noteId)
	    			.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	    	note.setTitle(noteDetails.getTitle());
	    	note.setContent(noteDetails.getContent());
	    	return noteRepository.save(note);
		}
	    // Delete a Note
		//@DeleteMapping("/notes/{id}")
		public ResponseEntity<?> deleteNote(@PathVariable(value="id")Long noteId)
		{
			Note note = noteRepository.findById(noteId)
	    			.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
			noteRepository.delete(note);
			return ResponseEntity.ok().build();
		}
}
