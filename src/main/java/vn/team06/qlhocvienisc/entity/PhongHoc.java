package vn.team06.qlhocvienisc.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "PHONGHOC")
@NamedStoredProcedureQueries({
	   @NamedStoredProcedureQuery(name = "PhongHoc.sp_delete_phonghoc", 
	                              procedureName = "sp_delete_phonghoc",
	                              parameters = {
	                                 @StoredProcedureParameter(
	                                		 mode = ParameterMode.IN,
	                                		 name = "maphong", 
	                                		 type = String.class)
	                              })
		})
public class PhongHoc {
	
	public PhongHoc() {
		
	}
	
	public PhongHoc(String mAPHG, String tENPHG) {
		super();
		MAPHG = mAPHG;
		TENPHG = tENPHG;
	}
	
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

}