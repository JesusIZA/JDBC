package entity;

public class Empl_Proj {
	
	private Long employeeId;
	private Long prijectId;
	
	public Empl_Proj(){}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getPrijectId() {
		return prijectId;
	}

	public void setPrijectId(Long prijectId) {
		this.prijectId = prijectId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((prijectId == null) ? 0 : prijectId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empl_Proj other = (Empl_Proj) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (prijectId == null) {
			if (other.prijectId != null)
				return false;
		} else if (!prijectId.equals(other.prijectId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empl_Proj [employeeId=" + employeeId + ", prijectId=" + prijectId + "]";
	}
	
	

}
