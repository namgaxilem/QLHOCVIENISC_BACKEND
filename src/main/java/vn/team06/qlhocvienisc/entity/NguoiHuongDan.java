package vn.team06.qlhocvienisc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NGUOIHUONGDAN")
public class NguoiHuongDan {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MANGUOIHDAN;
	
	private String HO;
	
	private String TENLOT;
	
	private String TEN;
	
	private String SDT;
	
	private String EMAIL;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TRUONG")
	TruongHoc truonghoc;

	public int getMANGUOIHDAN() {
		return MANGUOIHDAN;
	}

	public void setMANGUOIHDAN(int mANGUOIHDAN) {
		MANGUOIHDAN = mANGUOIHDAN;
	}

	public String getHO() {
		return HO;
	}

	public void setHO(String hO) {
		HO = hO;
	}

	public String getTENLOT() {
		return TENLOT;
	}

	public void setTENLOT(String tENLOT) {
		TENLOT = tENLOT;
	}

	public String getTEN() {
		return TEN;
	}

	public void setTEN(String tEN) {
		TEN = tEN;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public TruongHoc getTruonghoc() {
		return truonghoc;
	}

	public void setTruonghoc(TruongHoc truonghoc) {
		this.truonghoc = truonghoc;
	}
	
}
