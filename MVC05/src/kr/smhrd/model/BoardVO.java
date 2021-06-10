package kr.smhrd.model;
// 게시물 -> 번호, 제목, 내용, 작성자, 조회수, 작성일

import java.util.Date;

public class BoardVO {
	private int idx;
	private String title;
	private String contents;
	private String writer;
	private int count;
	private String indate;
	
	
	public int getIdx() {
		return idx;
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
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
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", title=" + title + ", contents=" + contents + ", writer=" + writer + ", count="
				+ count + ", indate=" + indate + "]";
	}
	
	
	
}
