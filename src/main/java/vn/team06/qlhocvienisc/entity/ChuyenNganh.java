package vn.team06.qlhocvienisc.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "CHUYENNGANH")
public class ChuyenNganh {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int ID;
	
	@Column(nullable = true)
	private String TENCN;
	
	@OneToMany(mappedBy = "chuyennganh", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<KhoaHoc> khoahoc;
	

	@ManyToMany(mappedBy="chuyennganh",fetch = FetchType.EAGER)
	private List<MonHoc> monhoc;
	

	

	public List<MonHoc> getMonhoc() {
		return monhoc;
	}

	public void setMonhoc(List<MonHoc> monhoc) {
		this.monhoc = monhoc;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTENCN() {
		return TENCN;
	}

	public void setTENCN(String tENCN) {
		TENCN = tENCN;
	}

	public Set<KhoaHoc> getKhoahoc() {
		return khoahoc;
	}

	public void setKhoahoc(Set<KhoaHoc> khoahoc) {
		this.khoahoc = khoahoc;
	}
	
}
