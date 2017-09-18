/**
 * UimUser.java 2011-9-5
 */
package model;

import java.util.Date;

/**
 * <p>
 * <b>UimUser</b> is
 * </p>
 *
 * @since 2011-9-5
 * @author zhengping_wang
 * @version $Id: UIMUser.java 4847 2014-02-14 07:10:02Z wzp $
 */
public class UIMUser {

	/** 用户名 */
	private String userName;
	
	/** 密码 */
	private String password;

	/** 用户类型 */
	private String userType;

	/** 用户来源 */
	private String userFrom;

	/** 用户编号 */
	private String userNo;

	/** 用户姓名 */
	private String userRealName;

	/** 用户所属组织 */
	private String orgCode;

	/** 生效日期 */
	private Date effectiveDate;

	/** 失效日期 */
	private Date inactiveDate;

	/** 是否有效 */
	private Boolean enabled;

	/** 上级用户帐号 */
	private String leaderAccount;

	/**
	 * 用户区域 由语言与地区字串拼接而成，中间用下划线连接。 语言字串遵循 ISO-639 标准，地区字串遵循 ISO-3166 标准。
	 */
	private String locale;

	/** 用户时区 采用TimeZone中 getAvailableIDs 方法获取的时区ID */
	private String timezone;

	/** 用户主题 */
	private String theme;

	/** 性别'F'：女；'M'：男 */
	private String sex;

	/** 移动电话 */
	private String mobile;

	/** 商务电话 */
	private String officeTel;

	/** 商务传真 */
	private String officeTax;

	/** 电子邮箱 */
	private String email;

	/** 电子邮箱2 */
	private String email2;

	/** 电子邮箱3 */
	private String email3;

	/** 即时通讯ID */
	private String imid;
	
	/** 职位 */
	private String officeTitle;
	
	/** 岗位 */
	private String officePost;

	private String syncType;

	private Long syncId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserFrom() {
		return userFrom;
	}

	public void setUserFrom(String userFrom) {
		this.userFrom = userFrom;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public Date getEffectiveDate() {
		return effectiveDate == null ? null : new Date(effectiveDate.getTime());
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate == null ? null : new Date(effectiveDate.getTime());
	}

	public Date getInactiveDate() {
		return inactiveDate == null ? null : new Date(inactiveDate.getTime());
	}

	public void setInactiveDate(Date inactiveDate) {
		this.inactiveDate = inactiveDate == null ? null : new Date(inactiveDate.getTime());
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getLeaderAccount() {
		return leaderAccount;
	}

	public void setLeaderAccount(String leaderAccount) {
		this.leaderAccount = leaderAccount;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOfficeTel() {
		return officeTel;
	}

	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}

	public String getOfficeTax() {
		return officeTax;
	}

	public void setOfficeTax(String officeTax) {
		this.officeTax = officeTax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public String getImid() {
		return imid;
	}

	public void setImid(String imid) {
		this.imid = imid;
	}

	public String getOfficeTitle() {
		return officeTitle;
	}

	public void setOfficeTitle(String officeTitle) {
		this.officeTitle = officeTitle;
	}

	public String getOfficePost() {
		return officePost;
	}

	public void setOfficePost(String officePost) {
		this.officePost = officePost;
	}

	public String getSyncType() {
		return syncType;
	}

	public void setSyncType(String syncType) {
		this.syncType = syncType;
	}

	public Long getSyncId() {
		return syncId;
	}

	public void setSyncId(Long syncId) {
		this.syncId = syncId;
	}
}
