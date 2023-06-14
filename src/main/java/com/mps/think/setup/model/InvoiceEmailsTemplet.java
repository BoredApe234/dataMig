package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invoice_email_tamplet")
public class InvoiceEmailsTemplet extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "email_tamplate_name")
	private String emailTamplateName;
	
	@Column(name = "text_formate")
	private String textFormate;
	
	@Column(name = "template_type")
	private String templateType;
	
	@Column(name = "default_status")
	private boolean defaultStatus;
	
	@OneToOne
	@JoinColumn(name = "publisher_id",referencedColumnName = "id")
	private Publisher publisher;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailTamplateName() {
		return emailTamplateName;
	}

	public void setEmailTamplateName(String emailTamplateName) {
		this.emailTamplateName = emailTamplateName;
	}

	public String getTextFormate() {
		return textFormate;
	}

	public void setTextFormate(String textFormate) {
		this.textFormate = textFormate;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public boolean isDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(boolean defaultStatus) {
		this.defaultStatus = defaultStatus;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "InvoiceEmailsTamplet [id=" + id + ", emailTamplateName=" + emailTamplateName + ", textFormate="
				+ textFormate + ", templateType=" + templateType + ", defaultStatus=" + defaultStatus + ", publisher="
				+ publisher + "]";
	}

	
}
