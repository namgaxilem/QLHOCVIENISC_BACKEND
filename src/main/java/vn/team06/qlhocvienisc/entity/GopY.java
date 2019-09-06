package vn.team06.qlhocvienisc.entity;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "GOPY")
public class GopY {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int ID;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="NGUOIGOPY", insertable=false, updatable=false)
//	@JsonManagedReference
    private HocVien hocvien;
	
	//@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="NGUOINHAN", insertable=false, updatable=false)
//	@JsonManagedReference
    //private CanBoGiangVien canbogiangvien;
	
	
	@Column(nullable = true)
	private String NOIDUNG;
	
	@Column(nullable = true)
	private Date NGAYNHAN;
	
	@Column(nullable = true)
	private String NGUOIGOPY;
	
	//@Column(nullable = true)
	//private String NGUOINHAN;
	

	//public String getNGUOINHAN() {
	//	return NGUOINHAN;
	//}

	//public void setNGUOINHAN(String nGUOINHAN) {
	//	NGUOINHAN = nGUOINHAN;
	//}
	
	public String getNGUOIGOPY() {
		return NGUOIGOPY;
	}

	public void setNGUOIGOPY(String nGUOIGOPY) {
		NGUOIGOPY = nGUOIGOPY;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}


	//public String getMaHocvien() {
	//	return hocvien.getMAHV();
	//}
	
	//public void setMaHocvien(String mahocvien) {
	//	hocvien.setMAHV(this.getMaHocvien());;
	//}
	
	//public String getTenHocvien() {
	//	return hocvien.getTEN();
	//}
	//public void setTenHocvien(String tenhocvien) {
	//	hocvien.setTEN(this.getTenHocvien());;
	//}
	

	//public HocVien getHocvien() {
	//	return hocvien;
	//}
	
	//public void setHocvien(HocVien hocvien) {
	//	this.hocvien = hocvien;
	//}

	//public HocVien getHocvien() {
	//	return hocvien;
	//}

	//public void setHocvien(HocVien hocvien) {
	//	this.hocvien = hocvien;
	//}


	public String getNOIDUNG() {
		return NOIDUNG;
	}

	public void setNOIDUNG(String nOIDUNG) {
		NOIDUNG = nOIDUNG;
	}

	public Date getNGAYNHAN() {
		return NGAYNHAN;
	}

	public void setNGAYNHAN(Date nGAYNHAN) {
		NGAYNHAN = nGAYNHAN;
	}
}
