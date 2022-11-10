package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguageTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdLanguageTechnologyResponse;

public interface LanguageTechnologyService {
	
	List<GetAllLanguageTechnologyResponse> getAll();
	
	void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest);
	void delete(DeleteLanguageTechnologyRequest deleteLanguageTechnologyRequest);
	void update(UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest);
	GetByIdLanguageTechnologyResponse getById(int id);
	
}
