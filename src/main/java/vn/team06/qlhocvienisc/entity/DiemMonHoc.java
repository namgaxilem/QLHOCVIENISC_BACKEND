package vn.team06.qlhocvienisc.entity;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "DIEMMONHOC")
public class DiemMonHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id;
	
	@Column(nullable = true)
	private Float diemgk;
	
	@Column(nullable = true)
	private Float diemhp;
	
	@Column(nullable = true)
	private Date ngaynhap;
	
	@Column(nullable = true)
	private String ketqua;
	
	@ManyToOne
    @JoinColumn(name="MAHV", insertable=false, updatable=false)
	@JsonBackReference
    private HocVien hocvien;
	
	@ManyToOne
	@JoinColumn(name="MAMH", insertable=false, updatable=false)
	private MonHoc monhoc;
	
	@ManyToOne
	@JoinColumn(name="MAGV", insertable=false, updatable=false)
	private CanBoGiangVien cbgv;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getDiemgk() {
		return diemgk;
	}

	public void setDiemgk(Float diemgk) {
		this.diemgk = diemgk;
	}

	public Float getDiemhp() {
		return diemhp;
	}

	public void setDiemhp(Float diemhp) {
		this.diemhp = diemhp;
	}

	public Date getNgaynhap() {
		return ngaynhap;
	}

	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}

	public String getKetqua() {
		return ketqua;
	}

	public void setKetqua(String ketqua) {
		this.ketqua = ketqua;
	}
	
	//-----------------------------
	
	public String getTenhv() {
		return (new StringBuilder()).append(hocvien.getHO() + " ")
				.append(hocvien.getTENLOT()  + " ")
				.append(hocvien.getTEN())
				.toString();
	}
	
	public String getTenmh() {
		return monhoc.getTENMH();
	}

	
	public String getTengv() {
		return (new StringBuilder()).append(cbgv.getHO() + " ")
				.append(cbgv.getTENLOT()  + " ")
				.append(cbgv.getTEN())
				.toString();
	}
	
	private String mahv;
	
	private String mamh;
	
	private String magv;
	
	public String getMahv() {
		return this.mahv;
	}
	
	public void setMahv(String ma) {
		this.mahv = ma;
	}
	
	public String getMamh() {
		return this.mamh;
	}
	
	public void setMamh(String ma) {
		this.mamh = ma;
	}
	
	public String getMagv() {
		return this.magv;
	}
	
	public void setMagv(String ma) {
		this.magv = ma;
	}
	
	public String getMakh() {
		return hocvien.getMAKHOAHOC();
	}

}