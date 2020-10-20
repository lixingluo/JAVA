package com.nmgtvb.booking;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
	private int id;
	private String name;
	private int status;
	private Date borrowDate;
	private Date returnDate;
	private int borrowCount;
	private int returnCount;
	public Book() {
		this.status = 1;
	}
	public Book(int id, String name) {
		this.id = id;
		this.name = name;
		this.status = 1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public String showStatus() {
		if(this.status == 1) {
			return "在库";
		} else {
			return "借出";
		}
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public String showBorrowDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String borrowDateString = borrowDate == null ? "-\t" : sdf.format(borrowDate);
		return borrowDateString;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String showReturnDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String returnDateString = returnDate == null ? "-\t" : sdf.format(returnDate);
		return returnDateString;
	}
	public int getBorrowCount() {
		return borrowCount;
	}
	public void setBorrowCount(int borrowCount) {
		this.borrowCount = borrowCount;
	}
	public void addBorrowCount(int num) {
		this.borrowCount = this.borrowCount + num;
	}
	public int getReturnCount() {
		return returnCount;
	}
	public void setReturnCount(int returnCount) {
		this.returnCount = returnCount;
	}
	public void addReturnCount(int num) {
		this.returnCount = this.returnCount + num;
	}
}
