package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguagesService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguagesRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Languages;

@Service
public class LanguagesManager implements LanguagesService {
	
	private LanguagesRepository languageRepository;
	
	@Autowired
	public LanguagesManager(LanguagesRepository languageRepository) {
	
		this.languageRepository = languageRepository;
	}


	@Override
	public List<GetAllLanguagesResponse> getAll() {
		// iş kuralları
		List<Languages> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> brandsResponse = new ArrayList<GetAllLanguagesResponse>();
		
		
		for(Languages language: languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			brandsResponse.add(responseItem);
		}
		
		return brandsResponse;
	}


	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		List<Languages> languages = languageRepository.findAll();
		int flag = 0;
		Languages language = new Languages();
		
		for(Languages language2: languages) {
			if(language2.getName().equals(createLanguageRequest.getName())) {
				flag++;
			}
		}
		if(flag == 0) {
			language.setName(createLanguageRequest.getName());
			this.languageRepository.save(language);
		}
	}


	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		List<Languages> languages = languageRepository.findAll();
		for(Languages language: languages) {
			if(language.getName().equals(deleteLanguageRequest.getName())) {
				this.languageRepository.delete(language);
			}
		}
			
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		Languages language = languageRepository.getById(updateLanguageRequest.getId());
		language.setName(updateLanguageRequest.getName());
		languageRepository.save(language);
	}


	@Override
	public GetByIdLanguagesResponse getById(int id) {
		List<Languages> languages = languageRepository.findAll();
		GetByIdLanguagesResponse getByIdLanguagesResponse = null;
		
		for(Languages language: languages) {
			if(language.getId() == id) {
				getByIdLanguagesResponse = new GetByIdLanguagesResponse();
				getByIdLanguagesResponse.setId(language.getId());
				getByIdLanguagesResponse.setName(language.getName());
			}
		}
		return getByIdLanguagesResponse;
	}


}
