package cn.hncu.xh.bookStore.out.vo;

import java.io.Serializable;

import cn.hncu.xh.bookStore.util.DateUtil;

/**
 *<p>Title:OutMainModel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class OutMainModel implements Serializable ,Comparable<OutMainModel>{
	private String uuid; //销售单uuid
	private String outUserUuid; //销售人uuid
	private Long outDate; //销售日期
	private String outUserName;//为了显示用户名，补的变量
	//下面是对应属性的set，get方法
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getOutUserUuid() {
		return outUserUuid;
	}
	public void setOutUserUuid(String outUserUuid) {
		this.outUserUuid = outUserUuid;
	}
	public Long getOutDate() {
		return outDate;
	}
	public void setOutDate(Long outDate) {
		this.outDate = outDate;
	}
	public String getOutUserName() {
		return outUserName;
	}
	public void setOutUserName(String outUserName) {
		this.outUserName = outUserName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final OutMainModel other = (OutMainModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return uuid+","+outUserName+","+DateUtil.LongToString(outDate);
	}
	//compareTo方法，根据uuid来排序
	public int compareTo(OutMainModel o) {
		return Integer.parseInt(this.uuid)-Integer.parseInt(o.uuid);
	}
	
	
	
}
