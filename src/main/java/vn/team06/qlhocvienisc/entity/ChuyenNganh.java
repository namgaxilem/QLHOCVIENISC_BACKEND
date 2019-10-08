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
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "CHUYENNGANH")
@NamedStoredProcedureQueries({
	   @NamedStoredProcedureQuery(name = "ChuyenNganh.sp_delete_ChuyenNganh", 
	                              procedureName = "sp_delete_ChuyenNganh",
	                              parameters = {
	                                 @StoredProcedureParameter(
	                                		 mode = ParameterMode.IN,
	                                		 name = "macn", 
	                                		 type = Integer.class)
	                              })
		})
public class ChuyenNganh {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int ID;
	
	@Column(nullable = true)
	private String TENCN;
	
	@OneToMany(mappedBy = "chuyennganh", 	
			fetch = FetchType.EAGER)
    private Set<KhoaHoc> khoahoc;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "DAOTAO",
    joinColumns = @JoinColumn(name = "CHUYENNGANH_ID"),
    inverseJoinColumns = @JoinColumn(name = "MAMH_ID"))
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
