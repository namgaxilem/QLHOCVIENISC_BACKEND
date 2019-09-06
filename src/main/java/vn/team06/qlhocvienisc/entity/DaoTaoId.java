package vn.team06.qlhocvienisc.entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
 
import java.io.Serializable;
 
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
public class DaoTaoId implements Serializable {
	private String MAMH_ID;
	 
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
