package vn.team06.qlhocvienisc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TINHNANG")
public class TinhNang {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int ID;
	
	@Column(nullable = true)
	private String TENMENU;
	
	@Column(nullable = true)
	private String LINK;
	
	@Column(nullable = true)
	private int TYPE;
	
	@ManyToOne()
	@JoinColumn(name = "TYPE", insertable=false, updatable=false)
	LoaiTaiKhoan loaitaikhoan;

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getTENMENU() {
		return TENMENU;
	}

	public void setTENMENU(String TENMENU) {
		this.TENMENU = TENMENU;
	}

	public String getLINK() {
		return LINK;
	}

	public void setLINK(String LINK) {
		this.LINK = LINK;
	}

	public LoaiTaiKhoan getLoaitaikhoan() {
		return loaitaikhoan;
	}

	public void setLoaitaikhoan(LoaiTaiKhoan loaitaikhoan) {
		this.loaitaikhoan = loaitaikhoan;
	}
	
	public int getType() {
		return TYPE;
	}
	
	public void setType(int TYPE) {
		this.TYPE = TYPE;
	}
	
}