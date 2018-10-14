package com.hany.notes.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.hany.notes.model.Note;

public interface INoteServices {
	
	List<Note> getAllNotes();
	Note createNote(@Valid @RequestBody Note note);
	Note getNoteById(@PathVariable(value ="id") Long noteId);
	Note updateNote(@PathVariable(value="id")Long noteId,@Valid @RequestBody Note noteDetails);
	ResponseEntity<?> deleteNote(@PathVariable(value="id")Long noteId);
}
