package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageTechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguageTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdLanguageTechnologyResponse;

@RestController
@RequestMapping("api/languageTechnologies")
public class LanguageTechnologyController {
	private LanguageTechnologyService languageTechnologyService;
	
	@Autowired
	public LanguageTechnologyController(LanguageTechnologyService languageTechnologyService) {
		this.languageTechnologyService = languageTechnologyService;
	}
	
	@GetMapping("/getAll")
	public List<GetAllLanguageTechnologyResponse> getAll() {
		return languageTechnologyService.getAll();
	}
	
	@GetMapping("/getById")
	public GetByIdLanguageTechnologyResponse getById(int id) {
		return languageTechnologyService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest) {
		languageTechnologyService.add(createLanguageTechnologyRequest);
	}
	
	@PostMapping("/delete")
	public void delete(DeleteLanguageTechnologyRequest deleteLanguageTechnologyRequest) {
		languageTechnologyService.delete(deleteLanguageTechnologyRequest);
	}
	
	@PostMapping("/update")
	public void update(UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest) {
		languageTechnologyService.update(updateLanguageTechnologyRequest);
	}
}
