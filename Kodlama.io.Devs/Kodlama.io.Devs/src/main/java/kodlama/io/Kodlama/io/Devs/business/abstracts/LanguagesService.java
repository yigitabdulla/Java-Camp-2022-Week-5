package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import org.hibernate.sql.Update;

import kodlama.io.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdLanguagesResponse;

public interface LanguagesService {
	
	List<GetAllLanguagesResponse> getAll();
	
	void add(CreateLanguageRequest createLanguageRequest);
	void delete(DeleteLanguageRequest deleteLanguageRequest);
	void update(UpdateLanguageRequest updateLanguageRequest);
	GetByIdLanguagesResponse getById(int id);
	
	//String getById(int id);
}
