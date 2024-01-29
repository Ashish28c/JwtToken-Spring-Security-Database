package com.isource.JwtTokenwithDatabase.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TenderDetailDTO implements Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	  @Id
	  @Column(name = "TenderId")
	  private long TenderId;
	  @Column(name="TenderCount")
	  private long TotalTendercnt;
	  @Column(name = "referenceNo")
	  private String referenceNo;
	  @Column(name = "RequirementWorkBrief")
	  private String RequirementWorkBrief;
	  @Column(name = "TenderDetailWorkDescription")
	  private String TenderDetailWorkDescription;
	  @Column(name = "TenderingAutority")
	  private String TenderingAutority;
	  @Column(name = "PrequalificationCriteria")
	  private String PrequalificationCriteria;
	  @Column(name = "TenderEstimatedCost")
	  private String TenderEstimatedCost;
	  @Column(name = "EarnestMoneyDeposite")
	  private String EarnestMoneyDeposite;
	  @Column(name = "DocumentFees")
	  private String DocumentFees;
	  @Column(name = "SubmissionEndDate")
	  private String SubmissionEndDate;
	  @Column(name = "TenderOpeningDate")
	  private String TenderOpeningDate;
	  @Column(name = "ContactAddress")
	  private String ContactAddress;
	  @Column(name = "ContactPerson")
	  private String ContactPerson;
	  @Column(name = "CurrencyName")
	  private String CurrencyName;
	  @Column(name = "StartDateOfDocCollection")
	  private String StartDateOfDocCollection;
	  @Column(name = "LastDateOfDocCollection")
	  private String LastDateOfDocCollection;
	  @Column(name = "PreBidMeetingDate")
	  private String PreBidMeetingDate;
	  @Column(name = "sitelocation")
	  private String sitelocation;
	  @Column(name = "Website")
	  private String Website;
	  @Column(name = "Keywords")
	  private String Keywords;
	  
	  @Column(name = "CreatedDate")
	  private String CreatedDate;
	public String getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(String createdDate) {
		CreatedDate = createdDate;
	}
	public long getTotalTendercnt() {
		return TotalTendercnt;
	}
	public void setTotalTendercnt(long totalTendercnt) {
		TotalTendercnt = totalTendercnt;
	}
	public long getTenderId() {
		return TenderId;
	}
	public void setTenderId(long tenderId) {
		TenderId = tenderId;
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
	public String getTenderDetailWorkDescription() {
		return TenderDetailWorkDescription;
	}
	public void setTenderDetailWorkDescription(String tenderDetailWorkDescription) {
		TenderDetailWorkDescription = tenderDetailWorkDescription;
	}
	public String getTenderingAutority() {
		return TenderingAutority;
	}
	public void setTenderingAutority(String tenderingAutority) {
		TenderingAutority = tenderingAutority;
	}
	public String getPrequalificationCriteria() {
		return PrequalificationCriteria;
	}
	public void setPrequalificationCriteria(String prequalificationCriteria) {
		PrequalificationCriteria = prequalificationCriteria;
	}
	public String getTenderEstimatedCost() {
		return TenderEstimatedCost;
	}
	public void setTenderEstimatedCost(String tenderEstimatedCost) {
		TenderEstimatedCost = tenderEstimatedCost;
	}
	public String getEarnestMoneyDeposite() {
		return EarnestMoneyDeposite;
	}
	public void setEarnestMoneyDeposite(String earnestMoneyDeposite) {
		EarnestMoneyDeposite = earnestMoneyDeposite;
	}
	public String getDocumentFees() {
		return DocumentFees;
	}
	public void setDocumentFees(String documentFees) {
		DocumentFees = documentFees;
	}
	public String getSubmissionEndDate() {
		return SubmissionEndDate;
	}
	public void setSubmissionEndDate(String submissionEndDate) {
		SubmissionEndDate = submissionEndDate;
	}
	public String getTenderOpeningDate() {
		return TenderOpeningDate;
	}
	public void setTenderOpeningDate(String tenderOpeningDate) {
		TenderOpeningDate = tenderOpeningDate;
	}
	public String getContactAddress() {
		return ContactAddress;
	}
	public void setContactAddress(String contactAddress) {
		ContactAddress = contactAddress;
	}
	public String getContactPerson() {
		return ContactPerson;
	}
	public void setContactPerson(String contactPerson) {
		ContactPerson = contactPerson;
	}
	public String getCurrencyName() {
		return CurrencyName;
	}
	public void setCurrencyName(String currencyName) {
		CurrencyName = currencyName;
	}
	public String getStartDateOfDocCollection() {
		return StartDateOfDocCollection;
	}
	public void setStartDateOfDocCollection(String startDateOfDocCollection) {
		StartDateOfDocCollection = startDateOfDocCollection;
	}
	public String getLastDateOfDocCollection() {
		return LastDateOfDocCollection;
	}
	public void setLastDateOfDocCollection(String lastDateOfDocCollection) {
		LastDateOfDocCollection = lastDateOfDocCollection;
	}
	public String getPreBidMeetingDate() {
		return PreBidMeetingDate;
	}
	public void setPreBidMeetingDate(String preBidMeetingDate) {
		PreBidMeetingDate = preBidMeetingDate;
	}
	public String getSitelocation() {
		return sitelocation;
	}
	public void setSitelocation(String sitelocation) {
		this.sitelocation = sitelocation;
	}
	public String getWebsite() {
		return Website;
	}
	public void setWebsite(String website) {
		Website = website;
	}
	public String getKeywords() {
		return Keywords;
	}
	public void setKeywords(String keywords) {
		Keywords = keywords;
	}
	@Override
	public String toString() {
		return "TenderDetailDTO [TotalTendercnt=" + TotalTendercnt + ", TenderId=" + TenderId + ", referenceNo="
				+ referenceNo + ", RequirementWorkBrief=" + RequirementWorkBrief + ", TenderDetailWorkDescription="
				+ TenderDetailWorkDescription + ", TenderingAutority=" + TenderingAutority
				+ ", PrequalificationCriteria=" + PrequalificationCriteria + ", TenderEstimatedCost="
				+ TenderEstimatedCost + ", EarnestMoneyDeposite=" + EarnestMoneyDeposite + ", DocumentFees="
				+ DocumentFees + ", SubmissionEndDate=" + SubmissionEndDate + ", TenderOpeningDate=" + TenderOpeningDate
				+ ", ContactAddress=" + ContactAddress + ", ContactPerson=" + ContactPerson + ", CurrencyName="
				+ CurrencyName + ", StartDateOfDocCollection=" + StartDateOfDocCollection + ", LastDateOfDocCollection="
				+ LastDateOfDocCollection + ", PreBidMeetingDate=" + PreBidMeetingDate + ", sitelocation="
				+ sitelocation + ", Website=" + Website + ", Keywords=" + Keywords + "]";
	}  
	  
		  
	  
}