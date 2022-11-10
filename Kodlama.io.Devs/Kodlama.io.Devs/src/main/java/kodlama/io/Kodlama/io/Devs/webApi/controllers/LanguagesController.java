package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguagesService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Languages;

@RestController  //annotation
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguagesService languageService;
	
	@Autowired
	public LanguagesController(LanguagesService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll() {
		return languageService.getAll();
	}
	
	@GetMapping("getById")
	public GetByIdLanguagesResponse getById(int id) {
		return languageService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(CreateLanguageRequest createLanguageRequest) {
		this.languageService.add(createLanguageRequest);
	}
	
	@PostMapping("/delete")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		this.languageService.delete(deleteLanguageRequest); 
	}
	
	@PostMapping("/update")
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		this.languageService.update(updateLanguageRequest);
	}
	
	
	
}
