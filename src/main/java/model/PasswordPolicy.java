/**
 * Copyright 2010-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package model;

/**
 * <p>
 * <b>PasswordPolicy</b> 密码策略
 * </p>
 *
 * @since 2011-10-14
 * @author zhengping_wang
 * @version $Id: PasswordPolicy.java 3809 2012-11-21 07:52:49Z wilson $
 */
public class PasswordPolicy {

	//是否启用语法检查
	private Boolean isCheckSyntax;

	//正则表达式规则
	private String regexSyntax;

	//正则表达式规则提示
	private String regexTips;

	//最小长度
	private int minLength;

	//是否启用历史记录功能
	private Boolean isEnableHistory;

	//历史记录次数
	private int historyCount;

	//是否启用失效功能
	private Boolean isAllowDisabled;

	//多少天，最大失效天数
	private int disabledMaxTime;

	//多少天，失效前多少天警告
	private int disabledAlertTime;

	//是否启用锁定
	private Boolean isLockAllowed;

	//最多失败次数
	private int maxFailNumber;

	//小时数，-1 表示直到管理员解锁
	private int keepLockedTime;

	public Boolean getIsCheckSyntax() {
		return isCheckSyntax;
	}

	public void setIsCheckSyntax(Boolean isCheckSyntax) {
		this.isCheckSyntax = isCheckSyntax;
	}

	public String getRegexSyntax() {
		return regexSyntax;
	}

	public void setRegexSyntax(String regexSyntax) {
		this.regexSyntax = regexSyntax;
	}

	public String getRegexTips() {
		return regexTips;
	}

	public void setRegexTips(String regexTips) {
		this.regexTips = regexTips;
	}

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public Boolean getIsEnableHistory() {
		return isEnableHistory;
	}

	public void setIsEnableHistory(Boolean isEnableHistory) {
		this.isEnableHistory = isEnableHistory;
	}

	public int getHistoryCount() {
		return historyCount;
	}

	public void setHistoryCount(int historyCount) {
		this.historyCount = historyCount;
	}

	public Boolean getIsAllowDisabled() {
		return isAllowDisabled;
	}

	public void setIsAllowDisabled(Boolean isAllowDisabled) {
		this.isAllowDisabled = isAllowDisabled;
	}

	public int getDisabledMaxTime() {
		return disabledMaxTime;
	}

	public void setDisabledMaxTime(int disabledMaxTime) {
		this.disabledMaxTime = disabledMaxTime;
	}

	public int getDisabledAlertTime() {
		return disabledAlertTime;
	}

	public void setDisabledAlertTime(int disabledAlertTime) {
		this.disabledAlertTime = disabledAlertTime;
	}

	public Boolean getIsLockAllowed() {
		return isLockAllowed;
	}

	public void setIsLockAllowed(Boolean isLockAllowed) {
		this.isLockAllowed = isLockAllowed;
	}

	public int getMaxFailNumber() {
		return maxFailNumber;
	}

	public void setMaxFailNumber(int maxFailNumber) {
		this.maxFailNumber = maxFailNumber;
	}

	public int getKeepLockedTime() {
		return keepLockedTime;
	}

	public void setKeepLockedTime(int keepLockedTime) {
		this.keepLockedTime = keepLockedTime;
	}
}
