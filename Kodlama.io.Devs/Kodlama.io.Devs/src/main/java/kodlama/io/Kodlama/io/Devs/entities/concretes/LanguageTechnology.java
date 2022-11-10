package kodlama.io.Kodlama.io.Devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="LanguageTechnology")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LanguageTechnology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tech_id")
	private int id;
	
	@Column(name="tech_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="language_id",referencedColumnName = "id")
	private Languages languages;
}
