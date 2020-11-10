package kr.or.wic.dto;

public class MemberDTO {
	private String id;
	private String name;
	private String addr;
	private String procile_pic;
	private String intro;
	private int closet_num;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getProcile_pic() {
		return procile_pic;
	}
	public void setProcile_pic(String procile_pic) {
		this.procile_pic = procile_pic;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getCloset_num() {
		return closet_num;
	}
	public void setCloset_num(int closet_num) {
		this.closet_num = closet_num;
	}
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", name=" + name + ", addr=" + addr + ", procile_pic=" + procile_pic + ", intro="
				+ intro + ", closet_num=" + closet_num + "]";
	}
	
	
}
