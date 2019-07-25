package entity;

import java.util.Date;

public class Borrow {
	private int id;
	private String book_id;
	private String reader_id;
	private Date borrowDate;
	private Date backDate;
	private int is_back;
	
	/**
	 * @return the backDate
	 */
	public Date getBackDate() {
		return backDate;
	}
	
	/**
	 * @param backDate the backDate to set
	 */
	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	}
	
	/**
	 * @return the book_id
	 */
	public String getBook_id() {
		return book_id;
	}
	
	/**
	 * @param book_id the book_id to set
	 */
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	
	/**
	 * @return the borrowDate
	 */
	public Date getBorrowDate() {
		return borrowDate;
	}
	
	/**
	 * @param borrowDate the borrowDate to set
	 */
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the is_back
	 */
	public int getIs_back() {
		return is_back;
	}
	
	/**
	 * @param is_back the is_back to set
	 */
	public void setIs_back(int is_back) {
		this.is_back = is_back;
	}
	
	/**
	 * @return the reader_id
	 */
	public String getReader_id() {
		return reader_id;
	}
	
	/**
	 * @param reader_id the reader_id to set
	 */
	public void setReader_id(String reader_id) {
		this.reader_id = reader_id;
	}
	
	
}
