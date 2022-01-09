package famarch.web.dbdata;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="Benutzer")
public class Benutzer {
	@Id
	private String name;

	private String berechtigung;

	private String passwort;
}
