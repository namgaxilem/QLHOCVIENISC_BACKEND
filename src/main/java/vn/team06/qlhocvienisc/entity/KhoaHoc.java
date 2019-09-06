package vn.team06.qlhocvienisc.entity;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "KHOAHOC")
public class KhoaHoc {
	@Id 
	@Column(columnDefinition = "LONGVARBINARY")
	private String MAKHOAHOC;
	
	private String TENKHOAHOC;
	
	private Date NGAYBD;
	
	private Date NGAYKT;
	
	private int CHUYENNGANH_ID;
	
	


	public int getCHUYENNGANH_ID() {
		return CHUYENNGANH_ID;
	}


	public void setCHUYENNGANH_ID(int cHUYENNGANH_ID) {
		CHUYENNGANH_ID = cHUYENNGANH_ID;
	}


	@OneToMany(mappedBy = "khoahoc", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<HocVien> hocvien;
	
	
	
	public Set<HocVien> getHocvien() {
		return hocvien;
	}


	public void setHocvien(Set<HocVien> hocvien) {
		this.hocvien = hocvien;
	}


	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CHUYENNGANH_ID", insertable=false, updatable=false)
    private ChuyenNganh chuyennganh;


	public String getMAKHOAHOC() {
		return MAKHOAHOC;
	}


	public void setMAKHOAHOC(String mAKHOAHOC) {
		MAKHOAHOC = mAKHOAHOC;
	}


	public String getTENKHOAHOC() {
		return TENKHOAHOC;
	}


	public void setTENKHOAHOC(String tENKHOAHOC) {
		TENKHOAHOC = tENKHOAHOC;
	}


	public Date getNGAYBD() {
		return NGAYBD;
	}


	public void setNGAYBD(Date nGAYBD) {
		NGAYBD = nGAYBD;
	}


	public Date getNGAYKT() {
		return NGAYKT;
	}


	public void setNGAYKT(Date nGAYKT) {
		NGAYKT = nGAYKT;
	}

	public void setChuyennganh(ChuyenNganh chuyennganh) {
		this.chuyennganh = chuyennganh;
	}
	
}
