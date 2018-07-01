package com.chenhongjuan.mavendemo;

import java.util.List;

public class TestMian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TencentPositionDao dao=new TencentPositionDaoImpl();
		List<TencentPosition> list=dao.searchAll();
		for(TencentPosition p:list){
			System.out.println(p.getPositionLink()+","+p.getPositionName()+","+p.getPositionNum()+","+p.getPositionType()+","+p.getPublishTime());
		}
	}

}
