package com.mawujun.generator.model;

import java.util.Comparator;

/**
 * 对属性进行排序，hidden=true的放在后面
 * @author mawujun
 *
 */
public class PropertyColumnComparator implements Comparator<PropertyColumn> {

	@Override
	public int compare(PropertyColumn o1, PropertyColumn o2) {
		// TODO Auto-generated method stub
		if("true".equalsIgnoreCase(o1.getHidden()) && "false".equalsIgnoreCase(o2.getHidden())){
			return 1;
		} else if("false".equalsIgnoreCase(o1.getHidden()) && "true".equalsIgnoreCase(o2.getHidden())){
			return -1;
		}
		return 0;
	}

}
