package kr.co.bit.vo;

public class BoardVo {
	private int board_seq;
	private String id;
	private String title;
	private String contents;
	private String modi_date;
	
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getModi_date() {
		return modi_date;
	}
	public void setModi_date(String modi_date) {
		this.modi_date = modi_date;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String info = "[번호]" + this.board_seq + "\r\n"+
				  	  "[작성자]" + this.id + "\r\n"+
				      "[제목]" + this.title + "\r\n"+
				      "[내용]" + this.contents+"\r\n"+
				      "[수정일]" + this.modi_date + "\r\n";
	 
		return info; 
	}
}
