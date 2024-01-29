package com.isource.JwtTokenwithDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TenderResultDetailDTO {

	 @Id
	  @GeneratedValue
	  
	  @Column(name = "TenderResultId")
	  private long TenderResultId;
	 @Column(name="TenderResultCount")
	  private long TenderResultCount; 
	 @Column(name = "referenceNo")
	  private String referenceNo;
	  @Column(name = "RequirementWorkBrief")
	  private String RequirementWorkBrief;
	  @Column(name = "sitelocation")
	  private String sitelocation;
	  @Column(name = "TenderingAutority")
	  private String TenderingAutority;
	  @Column(name = "contractValue")
	  private String contractValue;
	  @Column(name = "endSubmissionDate")
	  private String endSubmissionDate;
	  @Column(name = "CurrencyName")
	  private String CurrencyName;
	  
	  @Column(name = "qualifiedBidder")
	  private String qualifiedBidder;
	  
	  @Column(name = "contractorName")
	  private String contractorName;
	  
	  @Column(name = "contractorPhoneNo")
	  private String contractorPhoneNo;
	  
	  @Column(name = "contractorEmailId")
	  private String contractorEmailId;
	  @Column(name = "contractDate")
	  private String contractDate;
	  @Column(name = "submissionEndDate")
	  private String submissionEndDate;
	  
	  public String getSubmissionEndDate() {
		return submissionEndDate;
	}

	public void setSubmissionEndDate(String submissionEndDate) {
		this.submissionEndDate = submissionEndDate;
	}

	public String getContractDate() {
		return contractDate;
	}

	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	@Column(name = "Website")
	  private String Website;
	  
	  @Column(name = "Keywords")
	  private String Keywords;

	public long getTenderResultCount() {
		return TenderResultCount;
	}

	public void setTenderResultCount(long tenderResultCount) {
		TenderResultCount = tenderResultCount;
	}

	public long getTenderResultId() {
		return TenderResultId;
	}

	public void setTenderResultId(long tenderResultId) {
		TenderResultId = tenderResultId;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getRequirementWorkBrief() {
		return RequirementWorkBrief;
	}

	public void setRequirementWorkBrief(String requirementWorkBrief) {
		RequirementWorkBrief = requirementWorkBrief;
	}

	public String getSitelocation() {
		return sitelocation;
	}

	public void setSitelocation(String sitelocation) {
		this.sitelocation = sitelocation;
	}

	public String getContractValue() {
		return contractValue;
	}

	public void setContractValue(String contractValue) {
		this.contractValue = contractValue;
	}

	public String getEndSubmissionDate() {
		return endSubmissionDate;
	}

	public void setEndSubmissionDate(String endSubmissionDate) {
		this.endSubmissionDate = endSubmissionDate;
	}

	public String getTenderingAutority() {
		return TenderingAutority;
	}

	public void setTenderingAutority(String tenderingAutority) {
		TenderingAutority = tenderingAutority;
	}

	public String getCurrencyName() {
		return CurrencyName;
	}

	public void setCurrencyName(String currencyName) {
		CurrencyName = currencyName;
	}

	public String getQualifiedBidder() {
		return qualifiedBidder;
	}

	public void setQualifiedBidder(String qualifiedBidder) {
		this.qualifiedBidder = qualifiedBidder;
	}

	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}

	public String getContractorPhoneNo() {
		return contractorPhoneNo;
	}

	public void setContractorPhoneNo(String contractorPhoneNo) {
		this.contractorPhoneNo = contractorPhoneNo;
	}

	public String getContractorEmailId() {
		return contractorEmailId;
	}

	public void setContractorEmailId(String contractorEmailId) {
		this.contractorEmailId = contractorEmailId;
	}

	public String getKeywords() {
		return Keywords;
	}

	public void setKeywords(String keywords) {
		Keywords = keywords;
	}  
}
