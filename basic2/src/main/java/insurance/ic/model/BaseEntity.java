package insurance.ic.model;

import com.google.common.base.Preconditions;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "creationTime", columnDefinition = "datetime(3)")
	private Date creationTime;

	@Column(name = "modifiedBy")
	private String modifiedBy;

	@Column(name = "modificationTime", columnDefinition = "datetime(3)")
	private Date modificationTime;
	
	@Column(name = "organization")
	private String organization;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}
	
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		if(this.organization != null)
			Preconditions.checkNotNull(organization, "[FastFail]Organization cannot be set null");
		this.organization = organization;
	}


	@PrePersist
	protected void prePersist() {
		this.creationTime = new Date();
		this.modificationTime = new Date();

//		AuthenticationFacade authFacade = ApplicationContextUtils.getBean(AuthenticationFacade.class);
//		if(authFacade!=null) {
//			if(authFacade.getAuthentication()!=null) {
//				this.createdBy = authFacade.getAuthentication().getName();
//				this.modifiedBy = authFacade.getAuthentication().getName();
//			} else {
//				this.createdBy = "_UNKNOWN";
//				this.modifiedBy = "_UNKNOWN";
//			}
//			if(this.company == null)
//				this.company = authFacade.getCompany();
//			if(this.country == null)
//				this.country = authFacade.getCountry();
//		}
	}

	@PreUpdate
	protected void preUpdate() {
//		Preconditions.checkNotNull(country, "[FastFail]Country cannot be set null");
//		Preconditions.checkNotNull(company, "[FastFail]Company cannot be set null");
		this.modificationTime = new Date();

//		AuthenticationFacade authFacade = ApplicationContextUtils.getBean(AuthenticationFacade.class);
//		if(authFacade!=null && authFacade.getAuthentication()!=null) {
//			this.modifiedBy = authFacade.getAuthentication().getName();
//		} else {
//			this.modifiedBy = "_UNKNOWN";
//		}
	}
}
