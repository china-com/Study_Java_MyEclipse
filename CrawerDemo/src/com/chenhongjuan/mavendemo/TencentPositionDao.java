package com.chenhongjuan.mavendemo;

import java.util.List;

//Dao接口,设置一个add()方法
public interface TencentPositionDao {
	int add(TencentPosition position);
	List<TencentPosition> searchAll();
	//根据标题的字段查询
	List<TencentPosition> searchByName(String name);
}
