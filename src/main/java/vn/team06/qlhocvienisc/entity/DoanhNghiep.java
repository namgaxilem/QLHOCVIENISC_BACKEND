package vn.team06.qlhocvienisc.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DOANHNGHIEP")
public class DoanhNghiep {
	@Id 
	@Column(nullable = false)
	private int ID;
	
	@Column(nullable = true)
	private String TENDOANHNGHIEP;
	
	@Column(nullable = true)
	private String DIACHI;
	
	@Column(nullable = true)
	private String SDT;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTENDOANHNGHIEP() {
		return TENDOANHNGHIEP;
	}

	public void setTENDOANHNGHIEP(String tENDOANHNGHIEP) {
		TENDOANHNGHIEP = tENDOANHNGHIEP;
	}

	public String getDIACHI() {
		return DIACHI;
	}

	public void setDIACHI(String dIACHI) {
		DIACHI = dIACHI;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}
	
}