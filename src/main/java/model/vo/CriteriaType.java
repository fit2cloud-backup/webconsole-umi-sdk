/**
 * CriteriaType.java 2011-9-8
 */
package model.vo;


/**
 * <p>
 * <b>CriteriaType</b> is 比较符
 * </p>
 *
 * @since 2011-9-8
 * @author zhengping_wang
 * @version $Id: CriteriaType.java 4847 2014-02-14 07:10:02Z wzp $
 */
public enum CriteriaType {
	// like '%x'
	StartWith,
	// like 'x%'
	EndWith,
	// like '%x%'
	Contains,
	// not like '%x%'
	NotContains,
	// = x
	Equals,
	// > x
	GreaterThan,
	// >= x
	GreaterOrEqual,
	// < x
	LessThan,
	// <= x
	LessOrEqual,
	// <> x
	NotEqual,
	// < x 早于
	BeforeThan,
	// > x 晚于
	AfterThan,
	// >= x1 and < x2
	Between, Is,
	// in ( x1, x2 )
	In;
}
