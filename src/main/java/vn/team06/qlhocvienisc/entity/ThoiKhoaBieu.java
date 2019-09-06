package vn.team06.qlhocvienisc.entity;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "THOIKHOABIEU")
public class ThoiKhoaBieu {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int ID;
	
	@Column(nullable = true)
	private String GIOBD;
	
	@Column(nullable = true)
	private String GIOKT;
	
	@Column(nullable = true)
	private Date NGAYHOC;
	
	@ManyToOne//(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "MACBGV", insertable=false, updatable=false)
	private CanBoGiangVien cbgv;

	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "MAPHG", insertable=false, updatable=false)
	private PhongHoc phonghoc;
	
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "MAMH", insertable=false, updatable=false)
	private MonHoc monhoc;
	
	@ManyToOne//(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "MAKHOAHOC", insertable=false, updatable=false)
	private KhoaHoc khoahoc;
	
	private String macbgv;
	
	private String maphg;
	
	private String mamh;
	
	private String makhoahoc;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getGIOBD() {
		return (String) GIOBD.subSequence(0, 5);
	}

	public void setGIOBD(String gIOBD) {
		GIOBD = gIOBD;
	}

	public String getGIOKT() {
		return (String) GIOKT.subSequence(0, 5);
	}

	public void setGIOKT(String gIOKT) {
		GIOKT = gIOKT;
	}

	public Date getNGAYHOC() {
		return NGAYHOC;
	}

	public void setNGAYHOC(Date nGAYHOC) {
		NGAYHOC = nGAYHOC;
	}

	public String getMacbgv() {
		return this.macbgv;//cbgv.getMACBGV();
	}
	
	public String getTencbgv() {
		return (new StringBuilder()).append(cbgv.getHO() + " ")
				.append(cbgv.getTENLOT()  + " ")
				.append(cbgv.getTEN())
				.toString();  
	}

//	public void setCbgv(CanBoGiangVien cbgv) {
//		this.cbgv = cbgv;
//	}

	public String getMaphg() {
		return this.maphg;//phonghoc.getMAPHG();
	}
	
	public String getTenphg() {
		return phonghoc.getTENPHG();
	}

//	public void setPhonghoc(PhongHoc phonghoc) {
//		this.phonghoc = phonghoc;
//	}
	
	public String getMakhoahoc() {
		return this.makhoahoc;//khoahoc.getMAKHOAHOC();
	}
	
	public String getTenkhoahoc() {
		return khoahoc.getTENKHOAHOC();
	}
	
//	public void setKhoahoc(KhoaHoc khoahoc) {
//		this.khoahoc = khoahoc;
//	}
	
	public String getMamh() {
		return this.mamh;//monhoc.getMAMH();
	}
	
	public String getTenmh() {
		return monhoc.getTENMH();
	}
	
//	public void setMonhoc(MonHoc monhoc) {
//		this.monhoc = monhoc;
//	}
	
	public void setMacbgv(String macbgv) {
		this.macbgv = macbgv;
	}

	public void setMaphg(String maphg) {
		this.maphg = maphg;
	}

	public void setMamh(String mamh) {
		this.mamh = mamh;
	}

	public void setMakhoahoc(String makhoahoc) {
		this.makhoahoc = makhoahoc;
	}
	
}