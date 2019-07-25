package cn.hncu.xh.bookStore.in.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.hncu.xh.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.xh.bookStore.util.DateUtil;

/**
 *<p>Title:InMainModel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
public class InMainModel implements Serializable,Comparable<InMainModel>{
	private String uuid;//进货单编号
	private long inDate;//进货时间
	private String inUserUuid;//进货人编号，外键
	private String inUserName;//为外键补一个显示给用户看的字段
	//下面是属性的set，get方法
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getInDate() {
		return inDate;
	}
	public void setInDate(long inDate) {
		this.inDate = inDate;
	}
	public String getInUserUuid() {
		return inUserUuid;
	}
	public void setInUserUuid(String inUserUuid) {
		this.inUserUuid = inUserUuid;
	}
	
	public String getInUserName() {
		return inUserName;
	}
	public void setInUserName(String inUserName) {
		this.inUserName = inUserName;
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
		final InMainModel other = (InMainModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		String date=DateUtil.LongToString(inDate);
		return uuid+","+inUserName+","+date;
	}
	public int compareTo(InMainModel o) {
		return Integer.parseInt(uuid)-Integer.parseInt(o.uuid);
	}
	
}
