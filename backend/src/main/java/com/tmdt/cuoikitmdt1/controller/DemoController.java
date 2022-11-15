package com.tmdt.cuoikitmdt1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmdt.cuoikitmdt1.model.Demo;
import com.tmdt.cuoikitmdt1.repository.DemoRepository;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api")
public class DemoController {
	@Autowired
	DemoRepository demoRipository;
	
	@GetMapping("/demos")
	public ResponseEntity<List<Demo>> getAll() {
		try {
			List<Demo> list = new ArrayList<>();
			demoRipository.findAll().forEach(list::add);
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Demo>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/demos")
	public ResponseEntity<Demo> store(@RequestBody Demo demo) {
		try {
			Demo _demo = demoRipository.save(new Demo(demo.getTitle(), demo.getDescription()));
			
			if(_demo != null) {
				return new ResponseEntity<Demo>(_demo, HttpStatus.CREATED);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/demos/{id}")
	public ResponseEntity<Demo> update(@RequestBody Demo demo, @PathVariable("id") String id) {
		try {
			Optional<Demo> demoData = demoRipository.findById(id);
			
			if(demoData.isPresent()) {
				Demo _demo = demoData.get();
				_demo.setTitle(demo.getTitle());
				_demo.setDescription(demo.getDescription());
				return new ResponseEntity<Demo>(demoRipository.save(_demo), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/demos/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") String id) {
		try {
			demoRipository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
