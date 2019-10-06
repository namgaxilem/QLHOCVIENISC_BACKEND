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

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "KHOAHOC")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class KhoaHoc {
	@Id 
	@Column(columnDefinition = "LONGVARBINARY")
	private String MAKHOAHOC;
	@Column(nullable = true)
	private String TENKHOAHOC;
	@Column(nullable = true)
	private Date NGAYBD;
	@Column(nullable = true)
	private Date NGAYKT;
	@Column(nullable = true)
	private int CHUYENNGANH_ID;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CHUYENNGANH_ID", insertable=false, updatable=false)
    private ChuyenNganh chuyennganh;
	
	@OneToMany(mappedBy = "khoahoc", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
//	@Cascade(value= {org.hibernate.annotations.CascadeType.SAVE_UPDATE, 
//			org.hibernate.annotations.CascadeType.DELETE})
    private Set<HocVien> hocvien;
	
	@OneToMany(mappedBy = "khoahoc", 
			cascade = CascadeType.REMOVE, 
			fetch = FetchType.EAGER)
//	@Cascade(value= {org.hibernate.annotations.CascadeType.SAVE_UPDATE, 
//			org.hibernate.annotations.CascadeType.DELETE})
    private Set<ThongBao> thongbao;

	public Set<ThongBao> getThongbao() {
		return thongbao;
	}

	public void setThongbao(Set<ThongBao> thongbao) {
		this.thongbao = thongbao;
	}

	public int getCHUYENNGANH_ID() {
		return CHUYENNGANH_ID;
	}

	public void setCHUYENNGANH_ID(int cHUYENNGANH_ID) {
		CHUYENNGANH_ID = cHUYENNGANH_ID;
	}

	public Set<HocVien> getHocvien() {
		return hocvien;
	}

	public void setHocvien(Set<HocVien> hocvien) {
		this.hocvien = hocvien;
	}

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
