/**
 * CommonCondition.java 2011-9-7
 */
package model.vo;

/**
 * <p>
 * <b>CommonCondition</b> 通用条件
 * </p>
 *
 * @since 2011-9-7
 * @author zhengping_wang
 * @version $Id: CommonCondition.java 4847 2014-02-14 07:10:02Z wzp $
 */
public class CommonCondition {

	/** 要查询的条件字段(或属性)名称 */
	private String name;

	/** 字段数据类型：Boolean, Integer, Long, Double, String, Timestamp, Date */
	private DataType dataType;

	/** 
	 * 比较符：StartWith, EndWith, Contains, NotContains, Equals, GreaterThan, GreaterOrEqual
	 * LessThan, LessOrEqual, NotEqual, BeforeThan, AfterThan, Between, Is, In
	 **/
	private CriteriaType criteriaType;

	/** 条件值 */
	private Object value;

	/** 另一个条件值 */
	private Object anotherValue;
	
	/** 是否需要产生SQL片段 */
	private boolean queryPartCollect = true;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dataType
	 */
	public DataType getDataType() {
		return dataType;
	}

	/**
	 * @param dataType
	 *            the dataType to set
	 */
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return the criteriaType
	 */
	public CriteriaType getCriteriaType() {
		return criteriaType;
	}

	/**
	 * @param criteriaType
	 *            the criteriaType to set
	 */
	public void setCriteriaType(CriteriaType criteriaType) {
		this.criteriaType = criteriaType;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @return the anotherValue
	 */
	public Object getAnotherValue() {
		return anotherValue;
	}

	/**
	 * @param anotherValue
	 *            the anotherValue to set
	 */
	public void setAnotherValue(Object anotherValue) {
		this.anotherValue = anotherValue;
	}
	
	/**
	 * @return the queryPartCollect
	 */
	public boolean isQueryPartCollect() {
		return queryPartCollect;
	}

	/**
	 * @param queryPartCollect
	 *            the queryPartCollect to set
	 */
	public void setQueryPartCollect(boolean queryPartCollect) {
		this.queryPartCollect = queryPartCollect;
	}
}
