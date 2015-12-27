package tw.edu.nuk.java2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="animals")
public class animals{
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long no;
	
	//@Column(length=40)
	private String gender;
	
	@Column(length=30)
	private String category;
	
	@Column(name="findregion", length=30)
	private String findregion;
	
	@Column(length=60)
	private String age;
	
	@Column(length=15)
	private String color;
	
	@Column(length=15)
	private String address;

	public long getno() {
		return no;
	}

	public void setno(long no) {
		this.no = no;
	}

	public String gender() {
		return gender;
	}

	public void setgender(String gender) {
		this.gender = gender;
	}
	
	public String getcategory() {
		return category;
	}

	public void setcategorye(String category) {
		this.category = category;
	}

	public String getfindregion() {
		return findregion;
	}

	public void setfindregion(String findregion) {
		this.findregion = findregion;
	}

	public String getage() {
		return age;
	}

	public void setage(String age) {
		this.age = age;
	}

	public String getcolor() {
		return color;
	}

	public void setcolor(String color) {
		this.color =color;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	


}
