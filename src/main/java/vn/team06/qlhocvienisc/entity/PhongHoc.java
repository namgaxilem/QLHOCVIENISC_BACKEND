package vn.team06.qlhocvienisc.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PHONGHOC")
public class PhongHoc {
	@Id 
	@Column(nullable = false)
	private String MAPHG;
	
	@Column(nullable = true)
	private String TENPHG;
	
	@OneToMany(mappedBy="phonghoc")
    private List<ThoiKhoaBieu> thoikhoabieu;

	public String getMAPHG() {
		return MAPHG;
	}

	public void setMAPHG(String mAPHG) {
		MAPHG = mAPHG;
	}

	public String getTENPHG() {
		return TENPHG;
	}

	public void setTENPHG(String tENPHG) {
		TENPHG = tENPHG;
	}

	public PhongHoc(String mAPHG, String tENPHG) {
		super();
		MAPHG = mAPHG;
		TENPHG = tENPHG;
	}

	public PhongHoc() {
		super();
	}
}