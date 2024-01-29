package com.isource.JwtTokenwithDatabase.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TenderDocumentDTO implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	  @Id
	  @GeneratedValue
	  
	  @Column(name="TenderID")
	  private long Tenderid;
	  @Column(name="UserID")
	  private long UserID;
	  
	@Column(name="TenderDocumentCount")
	  private long TenderDocumentCount;
	  @Column(name = "CreatedDate")
	  private String CreatedDate;
	  @Column(name = "SourceYear")
	  private int year;
	  @Column(name = "SourceMonth")
	  private int month;
	  @Column(name = "SourceDay")
	  private int SourceDay;
	  @Column(name = "DestinactionYear")
	  private int DestinactionYear;
	  @Column(name = "DestinactionMonth")
	  private int DestinactionMonth;
	  @Column(name = "destinactionDay")
	  private int destinactionDay;
	  public long getTenderDocumentCount() {
			return TenderDocumentCount;
		}
		public void setTenderDocumentCount(long tenderDocumentCount) {
			TenderDocumentCount = tenderDocumentCount;
		}
	  	public long getTenderid() {
	  		return Tenderid;
		}
		public void setTenderid(long tenderid) {
			Tenderid = tenderid;
		}
		public String getCreatedDate() {
			return CreatedDate;
		}
		public void setCreatedDate(String createdDate) {
			CreatedDate = createdDate;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public int getMonth() {
			return month;
		}
		public void setMonth(int month) {
			this.month = month;
		}
		public int getSourceDay() {
			return SourceDay;
		}
		public void setSourceDay(int sourceDay) {
			SourceDay = sourceDay;
		}
		public int getDestinactionYear() {
			return DestinactionYear;
		}
		public void setDestinactionYear(int destinactionYear) {
			DestinactionYear = destinactionYear;
		}
		public int getDestinactionMonth() {
			return DestinactionMonth;
		}
		public void setDestinactionMonth(int destinactionMonth) {
			DestinactionMonth = destinactionMonth;
		}
		public int getDestinactionDay() {
			return destinactionDay;
		}
		public void setDestinactionDay(int destinactionDay) {
			this.destinactionDay = destinactionDay;
		}
		
		public long getUserID() {
			return UserID;
		}
		public void setUserID(long userID) {
			UserID = userID;
		}
		  
}
