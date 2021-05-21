package kr.smhrd.model;
// 게시물 -> 번호, 제목, 내용, 작성자, 조회수, 작성일

import java.util.Date;

public class BoardVO {
	private int idx;
	private String title;
	private String writer;
	private int count;
	private Date indate;
	private String contents;
	public int getIdx() {
		return idx;
	}
	@Override
	public String toString() { // 디버깅 용도
		return "BoardVO [idx=" + idx + ", title=" + title + ", writer=" + writer + ", count=" + count + ", indate="
				+ indate + ", contents=" + contents + "]";
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
}
