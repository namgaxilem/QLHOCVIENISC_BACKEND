package vn.team06.qlhocvienisc.entity;
import java.sql.Date;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "CANBO_GIANGVIEN")
@NamedStoredProcedureQueries({
   @NamedStoredProcedureQuery(name = "CanBoGiangVien.sp_delete_giangvien", 
                              procedureName = "sp_delete_giangvien",
                              parameters = {
                                 @StoredProcedureParameter(
                                		 mode = ParameterMode.IN,
                                		 name = "magv", 
                                		 type = String.class)
                              })
	})
public class CanBoGiangVien {
	@Id 
	@Column(nullable = false)
	private String MACBGV;
	
	@Column(nullable = true)
	private String HO;
	
	@Column(nullable = true)
	private String TENLOT;
	
	@Column(nullable = true)
	private String TEN;
	
	@Column(nullable = true)
	private String GIOITINH;
	
	@Column(nullable = true)
	private Date NGAYSINH;
	
	@Column(nullable = true)
	private Integer SDT;
	
	@Column(nullable = true)
	private String EMAIL;
	
	@Column(nullable = true)
	private String DIACHI;
	
	@Column(nullable = true)
	private String PASSWORD;
	
	@Column(nullable = true)
	private Integer ACCOUNTTYPE;
	
	public Integer getACCOUNTTYPE() {
		return ACCOUNTTYPE;
	}
	
	public void setACCOUNTTYPE(Integer ACCOUNTTYPE) {
		this.ACCOUNTTYPE = ACCOUNTTYPE;
	}
	
	@OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "cbgv")
//	@JsonBackReference
    private List<ThoiKhoaBieu> thoikhoabieu;
	
	@OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "cbgv")
//	@JsonBackReference
    private List<DiemMonHoc> diemmonhoc;
	
	public List<ThoiKhoaBieu> getThoikhoabieu() {
		return thoikhoabieu;
	}

	public void setThoikhoabieu(List<ThoiKhoaBieu> thoikhoabieu) {
		this.thoikhoabieu = thoikhoabieu;
	}

	public List<DiemMonHoc> getDiemmonhoc() {
		return diemmonhoc;
	}

	public void setDiemmonhoc(List<DiemMonHoc> diemmonhoc) {
		this.diemmonhoc = diemmonhoc;
	}
	
	public String getMACBGV() {
		return MACBGV;
	}

	public void setMACBGV(String mACBGV) {
		MACBGV = mACBGV;
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

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
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
}