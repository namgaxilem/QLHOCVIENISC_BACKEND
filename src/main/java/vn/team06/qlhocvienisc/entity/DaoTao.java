package vn.team06.qlhocvienisc.entity;
import lombok.Getter;
import lombok.Setter;
 
import javax.persistence.*;
 
@Entity
@Table(name = "DAOTAO")
@Setter
@Getter
@IdClass(DaoTaoId.class)
public class DaoTao {
	@Id
    private String MAMH_ID;
 
    @Id
    private Integer CHUYENNGANH_ID;

	public String getMAMH_ID() {
		return MAMH_ID;
	}

	public void setMAMH_ID(String mAMH_ID) {
		MAMH_ID = mAMH_ID;
	}

	public Integer getCHUYENNGANH_ID() {
		return CHUYENNGANH_ID;
	}

	public void setCHUYENNGANH_ID(Integer cHUYENNGANH_ID) {
		CHUYENNGANH_ID = cHUYENNGANH_ID;
	}

	
}
