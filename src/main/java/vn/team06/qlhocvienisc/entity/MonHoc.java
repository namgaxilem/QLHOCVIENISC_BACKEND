package vn.team06.qlhocvienisc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MONHOC")
public class MonHoc {
	@Id 
	@Column(nullable = false)
	private String MAMH;
	
	@Column(nullable = true)
	private String TENMH;

	@Column(nullable = true)
	private int SOGIO;
	
	@Column(nullable = true)
	private int SOTC;

	public int getSOTC() {
		return SOTC;
	}

	public void setSOTC(int sOTC) {
		SOTC = sOTC;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "DAOTAO",
	        joinColumns = @JoinColumn(name = "MAMH_ID"),
	        inverseJoinColumns = @JoinColumn(name = "CHUYENNGANH_ID"))
	private List<ChuyenNganh> chuyennganh;
	

	
	public void setChuyennganh(List<ChuyenNganh> chuyennganh) {
		this.chuyennganh = chuyennganh;
	}

	public String getMAMH() {
		return MAMH;
	}

	public void setMAMH(String mAMH) {
		MAMH = mAMH;
	}

	public String getTENMH() {
		return TENMH;
	}

	public void setTENMH(String tENMH) {
		TENMH = tENMH;
	}

	public int getSOGIO() {
		return SOGIO;
	}

	public void setSOGIO(int sOGIO) {
		SOGIO = sOGIO;
	}


	public MonHoc(String mAMH, String tENMH, int sOGIO) {
		super();
		MAMH = mAMH;
		TENMH = tENMH;
		SOGIO = sOGIO;
	}

	public MonHoc() {
		super();
	}
	
}
