package model;

public class AuditTrail {

	private String auditTrailId;
	private String modificationDate;
	
	public AuditTrail(String auditTrail, String modificationDate) {
		super();
		this.auditTrailId = auditTrail;
		this.modificationDate = modificationDate;
	}
	public String getAuditTrail() {
		return auditTrailId;
	}
	public void setAuditTrail(String auditTrail) {
		this.auditTrailId = auditTrail;
	}
	public String getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	
}
