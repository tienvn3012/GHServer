package vn.com.nct.base;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import vn.com.nct.constant.Constant;

public class BaseMethods {
	
	public DetachedCriteria setCondition(DetachedCriteria criteria, String... condition){
		for(int i=0;i<condition.length;i++){
			String[] split = condition[i].split(Constant.SPLIT_PATTERN);
			switch(split[2]) {
				case "=": 
					criteria.add(Restrictions.eq(split[0],split[1]));
					break;
				case "!=": 
					criteria.add(Restrictions.ne(split[0],split[1]));
					break;
				case ">" : 
					criteria.add(Restrictions.gt(split[0], split[1]));
					break;
				case "<" :
					criteria.add(Restrictions.lt(split[0], split[1]));
					break;
				case ">=" :
					criteria.add(Restrictions.ge(split[0], split[1]));
					break;
				case "<=" :
					criteria.add(Restrictions.le(split[0], split[1]));
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
					criteria.add(Restrictions.eq(split[0],split[1]));
					break;
				case "!=": 
					criteria.add(Restrictions.ne(split[0],split[1]));
					break;
				case ">" : 
					criteria.add(Restrictions.gt(split[0], split[1]));
					break;
				case "<" :
					criteria.add(Restrictions.lt(split[0], split[1]));
					break;
				case ">=" :
					criteria.add(Restrictions.ge(split[0], split[1]));
					break;
				case "<=" :
					criteria.add(Restrictions.le(split[0], split[1]));
					break;
				default : 
					break;
			}
		}
		
		return criteria;
	}
	
}
