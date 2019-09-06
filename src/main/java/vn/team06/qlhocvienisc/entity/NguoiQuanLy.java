package vn.team06.qlhocvienisc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NGUOIQUANLY")
public class NguoiQuanLy {

	@Id 
	@Column(nullable = false)
	private String MANQL;
	
	private String HO;
	
	private String TENLOT;
	
	private String TEN;
	
	private String GIOITINH;

	private String EMAIL;
	
	private Date NGAYSINH;
	
	private String NOISINH;
	
	private int CMND;
	
	private int SDT;
	
	private String DIACHI;
	
	private int LUONG;
	
	private int HSLUONG;
	
	private Date NGAYVAOLAM;
	
	private String PASSWORD;
	
	private int ACCOUNTTYPE;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ACCOUNTTYPE", insertable=false, updatable=false)
    private LoaiTaiKhoan loaitaikhoan;

	public String getMANQL() {
		return MANQL;
	}

	public void setMANQL(String mANQL) {
		MANQL = mANQL;
	}

	public String getHO() {
		return HO;
	}

	public void setHO(String hO) {
		HO = hO;
	}

	public String getTENLOT() {
		return TENLOT;
	}

	public void setTENLOT(String tENLOT) {
		TENLOT = tENLOT;
	}

	public String getTEN() {
		return TEN;
	}

	public void setTEN(String tEN) {
		TEN = tEN;
	}

	public String getGIOITINH() {
		return GIOITINH;
	}

	public void setGIOITINH(String gIOITINH) {
		GIOITINH = gIOITINH;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public Date getNGAYSINH() {
		return NGAYSINH;
	}

	public void setNGAYSINH(Date nGAYSINH) {
		NGAYSINH = nGAYSINH;
	}

	public String getNOISINH() {
		return NOISINH;
	}

	public void setNOISINH(String nOISINH) {
		NOISINH = nOISINH;
	}

	public int getCMND() {
		return CMND;
	}

	public void setCMND(int cMND) {
		CMND = cMND;
	}

	public int getSDT() {
		return SDT;
	}

	public void setSDT(int sDT) {
		SDT = sDT;
	}

	public String getDIACHI() {
		return DIACHI;
	}

	public void setDIACHI(String dIACHI) {
		DIACHI = dIACHI;
	}

	public int getLUONG() {
		return LUONG;
	}

	public void setLUONG(int lUONG) {
		LUONG = lUONG;
	}

	public int getHSLUONG() {
		return HSLUONG;
	}

	public void setHSLUONG(int hSLUONG) {
		HSLUONG = hSLUONG;
	}

	public Date getNGAYVAOLAM() {
		return NGAYVAOLAM;
	}

	public void setNGAYVAOLAM(Date nGAYVAOLAM) {
		NGAYVAOLAM = nGAYVAOLAM;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public int getACCOUNTTYPE() {
		return ACCOUNTTYPE;
	}

	public void setACCOUNTTYPE(int aCCOUNTTYPE) {
		ACCOUNTTYPE = aCCOUNTTYPE;
	}
}