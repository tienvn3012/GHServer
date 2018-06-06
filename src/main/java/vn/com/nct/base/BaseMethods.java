package vn.com.nct.base;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import vn.com.nct.constant.Constant;

/*
 *
 * Class name: BaseMethod
 * Class purpose: some base method for set hibernate DB query 
 */

public class BaseMethods {
	
	
	/*
	 * set condition for DB criteria
	 * Param 1: hibernate criteria
	 * Param 2: array of condition
	 * condition form: property;value;equaltion;property type 
	 */
	public DetachedCriteria setCondition(DetachedCriteria criteria, String... condition){
		for(int i=0;i<condition.length;i++){
			String[] split = condition[i].split(Constant.SPLIT_PATTERN);
			switch(split[2]) {
				case "=": 
					criteria.add(Restrictions.eq(split[0],parseDataType(split[3], split[1])));
					break;
				case "!=": 
					criteria.add(Restrictions.ne(split[0],parseDataType(split[3], split[1])));
					break;
				case ">" : 
					criteria.add(Restrictions.gt(split[0],parseDataType(split[3], split[1])));
					break;
				case "<" :
					criteria.add(Restrictions.lt(split[0],parseDataType(split[3], split[1])));
					break;
				case ">=" :
					criteria.add(Restrictions.ge(split[0],parseDataType(split[3], split[1])));
					break;
				case "<=" :
					criteria.add(Restrictions.le(split[0],parseDataType(split[3], split[1])));
					break;
				default : 
					break;
			}
		}

		return criteria;
	}
	
	public Criteria setConditionCriteria(Criteria criteria, String... condition){
		for(int i=0;i<condition.length;i++){
			String[] split = condition[i].split(Constant.SPLIT_PATTERN);
			switch(split[2]) {
				case "=": 
					criteria.add(Restrictions.eq(split[0],parseDataType(split[3], split[1])));
					break;
				case "!=": 
					criteria.add(Restrictions.ne(split[0],parseDataType(split[3], split[1])));
					break;
				case ">" : 
					criteria.add(Restrictions.gt(split[0],parseDataType(split[3], split[1])));
					break;
				case "<" :
					criteria.add(Restrictions.lt(split[0],parseDataType(split[3], split[1])));
					break;
				case ">=" :
					criteria.add(Restrictions.ge(split[0],parseDataType(split[3], split[1])));
					break;
				case "<=" :
					criteria.add(Restrictions.le(split[0],parseDataType(split[3], split[1])));
					break;
				default : 
					break;
			}
		}
		
		return criteria;
	}
	
	private Object parseDataType(String data_type, String value){
		if(data_type.equals("int"))
			return Integer.parseInt(value);
		else if(data_type.equals("double"))
			return Double.parseDouble(value);
		else if(data_type.equals("float"))
			return Float.parseFloat(value);
		else if(data_type.equals("boolean"))
			return Boolean.parseBoolean(value);
		else if(data_type.equals("String"))
			return value;
		else if(data_type.equals("long"))
			return Long.parseLong(value);
		else if(data_type.equals("byte"))
			return Byte.parseByte(value);
		else
			return Integer.parseInt(value);
		
	}
	
}
