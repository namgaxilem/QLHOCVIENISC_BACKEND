package vn.team06.qlhocvienisc.entity;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "THONGBAO")
public class ThongBao implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int ID;
	
	@Column(nullable = true)
	private String TIEUDE;
	
	@Column(nullable = true)
	private String NOIDUNG;
	
	@Column(nullable = true)
	private Date NGAYDANG;
	
	@ManyToOne
	@JoinColumn(name = "NGUOIDANG", insertable=false, updatable=false)
	private NguoiQuanLy nql;
	
	@ManyToOne
	@JoinColumn(name = "MAKHOAHOC", insertable=false, updatable=false)
	private KhoaHoc khoahoc;
	
	private String makhoahoc;
	
	private String nguoidang;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTIEUDE() {
		return TIEUDE;
	}

	public void setTIEUDE(String tIEUDE) {
		TIEUDE = tIEUDE;
	}

	public String getNOIDUNG() {
		return NOIDUNG;
	}

	public void setNOIDUNG(String nOIDUNG) {
		NOIDUNG = nOIDUNG;
	}

	public Date getNGAYDANG() {
		return NGAYDANG;
	}

	public void setNGAYDANG(Date nGAYDANG) {
		NGAYDANG = nGAYDANG;
	}
	
	public String getNguoidang() {
		return nguoidang;
	}
	
	public void setNguoidang(String ma) {
		this.nguoidang = ma;
	}
	
	public String getTennguoidang() {
		return nql.getTEN();
	}

//	public void setNql(NguoiQuanLy nql) {
//		this.nql = nql;
//	}
	
	public String getMakhoahoc() {
		return makhoahoc;
	}
	
	public void setMakhoahoc(String ma) {
		this.makhoahoc = ma;
	}
	
	public String getTenkhoahoc() {
		return khoahoc.getTENKHOAHOC();
	}
	
//	public void setKhoahoc(KhoaHoc khoahoc) {
//		this.khoahoc = khoahoc;
//	}
	
}