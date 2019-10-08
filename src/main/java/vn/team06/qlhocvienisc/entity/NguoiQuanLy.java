package vn.team06.qlhocvienisc.entity;

import java.util.Date;
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

import antlr.collections.List;

@Entity
@Table(name = "NGUOIQUANLY")
public class NguoiQuanLy {

	@Id 
	@Column(nullable = false)
	private String MANQL;
	@Column(nullable = true)
	private String HO;
	@Column(nullable = true)
	private String TENLOT;
	@Column(nullable = true)
	private String TEN;
	@Column(nullable = true)
	private String GIOITINH;
	@Column(nullable = true)
	private String EMAIL;
	@Column(nullable = true)
	private Date NGAYSINH;	
	@Column(nullable = true)
	private Integer SDT;
	@Column(nullable = true)
	private String DIACHI;
	@Column(nullable = true)
	private String PASSWORD;
	@Column(nullable = true)
	private int ACCOUNTTYPE;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ACCOUNTTYPE", insertable=false, updatable=false)
    private LoaiTaiKhoan loaitaikhoan;
	
	@OneToMany(cascade = { CascadeType.REMOVE },
			 mappedBy = "nql")
	private Set<ThongBao> thongbao;
	
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

	public Integer getSDT() {
		return SDT;
	}

	public void setSDT(Integer sDT) {
		SDT = sDT;
	}

	public String getDIACHI() {
		return DIACHI;
	}

	public void setDIACHI(String dIACHI) {
		DIACHI = dIACHI;
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