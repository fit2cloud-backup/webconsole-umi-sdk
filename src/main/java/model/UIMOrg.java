/**
 * UIMOrg.java 2011-9-7
 */
package model;

import java.util.Date;

/**
 * <p>
 * <b>UIMOrg</b> 组织数据结构
 * </p>
 *
 * @since 2011-9-7
 * @author zhengping_wang
 * @version $Id: UIMOrg.java 4847 2014-02-14 07:10:02Z wzp $
 */
public class UIMOrg {
	/** 组织编码 */
	private String code;
	
	/** 组织名称 */
	private String name;
	
	/** OA组织ID */
	private Long oaId;
	
	/** OA组织父ID */
	private Long parentId;
	
	/** 组织简称 */
	private String simpleName;
	
	/** 是否有下级组织 */
	private Boolean group;
	
	/** 组织排序编码 */
	private Integer ordered;
	
	/** 组织主管帐号 */
	private String leaderAccount;
	
	/** 组织级别 */
	private Integer level;
	
	/** 组织类型 */
	private String type;
	
	/** 是否有效 */
	private Boolean enabled;
	
	/** 组织创建日期 */
	private Date foundDate;
	
	/** 同步ID */
	private Long syncId;
	
	/** 同步状态 */
	private String syncType;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getOaId() {
		return oaId;
	}

	public void setOaId(Long oaId) {
		this.oaId = oaId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public Boolean getGroup() {
		return group;
	}

	public void setGroup(Boolean group) {
		this.group = group;
	}

	public Integer getOrdered() {
		return ordered;
	}

	public void setOrdered(Integer ordered) {
		this.ordered = ordered;
	}

	public String getLeaderAccount() {
		return leaderAccount;
	}

	public void setLeaderAccount(String leaderAccount) {
		this.leaderAccount = leaderAccount;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}

	public Long getSyncId() {
		return syncId;
	}

	public void setSyncId(Long syncId) {
		this.syncId = syncId;
	}

	public String getSyncType() {
		return syncType;
	}

	public void setSyncType(String syncType) {
		this.syncType = syncType;
	}
}
