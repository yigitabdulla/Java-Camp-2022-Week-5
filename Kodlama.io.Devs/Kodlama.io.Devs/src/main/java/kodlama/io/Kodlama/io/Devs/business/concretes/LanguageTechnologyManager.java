package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageTechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguageTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdLanguageTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageTechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.LanguageTechnology;

@Service
public class LanguageTechnologyManager implements LanguageTechnologyService {
	private LanguageTechnologyRepository languageTechnologyRepository;
	
	@Autowired
	public LanguageTechnologyManager (LanguageTechnologyRepository languageTechnologyRepository) {
		this.languageTechnologyRepository = languageTechnologyRepository;
	}
	
	

	@Override
	public void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest) {
		List<LanguageTechnology> languageTechnologies = languageTechnologyRepository.findAll();
		int flag = 0;
		LanguageTechnology languageTech = new LanguageTechnology();
		
		for(LanguageTechnology techs: languageTechnologies) {
			if(techs.getName().equals(createLanguageTechnologyRequest.getName())) {
				flag++;
			}
		}
		if(flag == 0) {
			languageTech.setName(createLanguageTechnologyRequest.getName());
			this.languageTechnologyRepository.save(languageTech);
		}
		
	}

	@Override
	public void delete(DeleteLanguageTechnologyRequest deleteLanguageTechnologyRequest) {
		List<LanguageTechnology> languageTechnologies = languageTechnologyRepository.findAll();
		for(LanguageTechnology techs: languageTechnologies) {
			if(techs.getName().equals(deleteLanguageTechnologyRequest.getName())) {
				this.languageTechnologyRepository.delete(techs);
			}
		}
		
	}

	@Override
	public void update(UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest) {
		LanguageTechnology languageTechnology = languageTechnologyRepository.getById(updateLanguageTechnologyRequest.getId());
		languageTechnology.setName(updateLanguageTechnologyRequest.getName());
		languageTechnologyRepository.save(languageTechnology);
		
	}

	@Override
	public GetByIdLanguageTechnologyResponse getById(int id) {
		List<LanguageTechnology> languageTechnologies = languageTechnologyRepository.findAll();
		GetByIdLanguageTechnologyResponse getByIdLanguageTechnologyResponse = null;
		for(LanguageTechnology techs: languageTechnologies) {
			if(techs.getId()==id) {
				getByIdLanguageTechnologyResponse = new GetByIdLanguageTechnologyResponse();
				getByIdLanguageTechnologyResponse.setId(id);
				getByIdLanguageTechnologyResponse.setName(techs.getName());
			}
		}
		return getByIdLanguageTechnologyResponse;
	}



	@Override
	public List<GetAllLanguageTechnologyResponse> getAll() {
		List<LanguageTechnology> languageTechnologies = languageTechnologyRepository.findAll();
		List<GetAllLanguageTechnologyResponse> brandsResponse = new ArrayList<GetAllLanguageTechnologyResponse>();
		
		for(LanguageTechnology techs: languageTechnologies) {
			GetAllLanguageTechnologyResponse responseItem = new GetAllLanguageTechnologyResponse();
			responseItem.setId(techs.getId());
			responseItem.setName(techs.getName());
			brandsResponse.add(responseItem);
		}
		return brandsResponse;
	}



	
}
