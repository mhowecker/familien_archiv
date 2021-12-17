package famarch.web.dbdata;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="Partnerschaften")
public class Partnerschaft {

	@Id
	int nummer;
	int person1;
	int person2;
	Date von;
	Date bis;
	
	public Partnerschaft(int nummer, int person1, int person2, Date von, Date bis) {
		super();
		this.nummer = nummer;
		this.person1 = person1;
		this.person2 = person2;
		this.von = von;
		this.bis = bis;
	}

	public Partnerschaft() {

	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public int getPerson1() {
		return person1;
	}

	public void setPerson1(int person1) {
		this.person1 = person1;
	}

	public int getPerson2() {
		return person2;
	}

	public void setPerson2(int person2) {
		this.person2 = person2;
	}

	public Date getVon() {
		return von;
	}

	public void setVon(Date von) {
		this.von = von;
	}

	public Date getBis() {
		return bis;
	}

	public void setBis(Date bis) {
		this.bis = bis;
	}
	
	
}
