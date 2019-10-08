package vn.team06.qlhocvienisc.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "TRUONGHOC")
@NamedStoredProcedureQueries({
	   @NamedStoredProcedureQuery(name = "TruongHoc.sp_delete_truonghoc", 
	                              procedureName = "sp_delete_truonghoc",
	                              parameters = {
	                                 @StoredProcedureParameter(
	                                		 mode = ParameterMode.IN,
	                                		 name = "matruong", 
	                                		 type = String.class)
	                              })
		})
public class TruongHoc {
	@Id 
	@Column(columnDefinition = "LONGVARBINARY")
	private String MATRUONG;
	
	private String TENTRUONG;
	
	private String DIACHI;
	
	private String SDT;
	

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	@OneToMany(mappedBy = "truonghoc",
			
			fetch = FetchType.EAGER)
    private Set<HocVien> hocvien;
	

	public Set<HocVien> getHocvien() {
		return hocvien;
	}

	public void setHocvien(Set<HocVien> hocvien) {
		this.hocvien = hocvien;
	}

	public String getMATRUONG() {
		return MATRUONG;
	}

	public void setMATRUONG(String mATRUONG) {
		MATRUONG = mATRUONG;
	}

	public String getTENTRUONG() {
		return TENTRUONG;
	}

	public void setTENTRUONG(String tENTRUONG) {
		TENTRUONG = tENTRUONG;
	}

	public String getDIACHI() {
		return DIACHI;
	}

	public void setDIACHI(String dIACHI) {
		DIACHI = dIACHI;
	}

	public TruongHoc(String mATRUONG, String tENTRUONG, String dIACHI) {
		super();
		MATRUONG = mATRUONG;
		TENTRUONG = tENTRUONG;
		DIACHI = dIACHI;
	}

	public TruongHoc() {
		super();
	}
	
}
