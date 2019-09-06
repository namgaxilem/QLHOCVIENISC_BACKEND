package vn.team06.qlhocvienisc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "HOSO")
public class HoSo {
	@Id 
	@Column(nullable = false)
	private int ID;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MAHV", nullable = false)
	@JsonBackReference
    private HocVien hocvien;
	
	@Column(nullable = true)
	private Boolean BANGDIEM;
	
	@Column(nullable = true)
	private Boolean CMND;
	
	@Column(nullable = true)
	private Boolean DATCOC;
	
	@Column(nullable = true)
	private Boolean HINHANH;
	
	@Column(nullable = true)
	private String CHUTHICH;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public HocVien getHocvien() {
		return hocvien;
	}

	public void setHocvien(HocVien hocvien) {
		this.hocvien = hocvien;
	}

	public Boolean getBANGDIEM() {
		return BANGDIEM;
	}

	public void setBANGDIEM(Boolean bANGDIEM) {
		BANGDIEM = bANGDIEM;
	}

	public Boolean getCMND() {
		return CMND;
	}

	public void setCMND(Boolean cMND) {
		CMND = cMND;
	}

	public Boolean getDATCOC() {
		return DATCOC;
	}

	public void setDATCOC(Boolean dATCOC) {
		DATCOC = dATCOC;
	}

	public Boolean getHINHANH() {
		return HINHANH;
	}

	public void setHINHANH(Boolean hINHANH) {
		HINHANH = hINHANH;
	}

	public String getCHUTHICH() {
		return CHUTHICH;
	}

	public void setCHUTHICH(String cHUTHICH) {
		CHUTHICH = cHUTHICH;
	}
	
	
}
