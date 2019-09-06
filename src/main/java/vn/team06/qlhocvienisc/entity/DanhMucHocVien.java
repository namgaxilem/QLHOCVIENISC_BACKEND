package vn.team06.qlhocvienisc.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "DANHMUCHOCVIEN")
public class DanhMucHocVien {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	
	private String TENLOAI;
	
	@OneToMany(mappedBy = "danhmuchocvien", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<HocVien> hocvien;
	
	

	public Set<HocVien> getHocvien() {
		return hocvien;
	}

	public void setHocvien(Set<HocVien> hocvien) {
		this.hocvien = hocvien;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getTENLOAI() {
		return TENLOAI;
	}

	public void setTENLOAI(String tENLOAI) {
		TENLOAI = tENLOAI;
	}
}
