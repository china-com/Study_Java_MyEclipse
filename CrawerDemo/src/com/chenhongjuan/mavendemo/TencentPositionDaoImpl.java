package com.chenhongjuan.mavendemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Dao接口的实现类，实现add()方法，实现向数据库中写入数据
public class TencentPositionDaoImpl implements TencentPositionDao {
	public int add(TencentPosition position) {
		// SQL插入语句
		String sql = "INSERT INTO tencent_position(p_name, p_link, p_type, p_num, p_location, p_publish_time)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pst = null;
		// 设置插入的数据
		try {
			conn = MySQLUtils.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, position.getPositionName());
			pst.setString(2, position.getPositionLink());
			pst.setString(3, position.getPositionType());
			pst.setString(4, position.getPositionNum());
			pst.setString(5, position.getWorkLocation());
			pst.setString(6, position.getPublishTime());
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库的连接
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					pst = null;
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					conn = null;
				}
			}
		}
		return 0;
	}

	public List<TencentPosition> searchAll() {
		List<TencentPosition> tencent = null;
		tencent=new ArrayList<TencentPosition>();
		try {
			// 加载驱动
			// 获取链接
			Connection conn = MySQLUtils.getConnection();
			// 创建Statement
			Statement stmt = conn.createStatement();
			// 创建SQL
			String sql = "select * from tencent_position";
			// 调用Statement的execute，执行sql
			ResultSet rs = stmt.executeQuery(sql);
			// 处理执行结果
			while (rs.next()) {// 向下以偶定指针
				// 获取当前指针所对应记录的数据（每个字段）
				// 根据字段的顺序获取值
				int id = rs.getInt(1);
				// 根据字段名称获取值
				String name = rs.getString("p_name");
				String link = rs.getString("p_link");
				String type = rs.getString("p_type");
				String num = rs.getString("p_num");
				String location = rs.getString("p_location");
				String publish_time = rs.getString("p_publish_time");
				
				//将值封装到position对象中
				TencentPosition position=new TencentPosition();
				position.setPositionLink(link);
				position.setPositionName(name);
				position.setPositionNum(num);
				position.setPositionType(type);
				position.setPublishTime(publish_time);
				position.setWorkLocation(location);
				
				//将position对象，添加到list
				tencent.add(position);
			}
			// 关闭所有资源
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tencent;
	}

	@Override
	public List<TencentPosition> searchByName(String oname) {
		// TODO Auto-generated method stub
		List<TencentPosition> list=null;
		list=new ArrayList<TencentPosition>();
		try {
			// 加载驱动
			// 获取链接
			Connection conn = MySQLUtils.getConnection();
			// 创建Statement
			Statement stmt = conn.createStatement();
			// 创建SQL
			String sql = "select * from tencent_position";
			//判断输入框的输入是否为空
			if(oname!=null&&!oname.trim().equals("")){
				sql+=" where p_name like '%"+oname+"%'";
			}
			// 调用Statement的execute，执行sql
			ResultSet rs = stmt.executeQuery(sql);
			// 处理执行结果
			while (rs.next()) {// 向下以偶定指针
				// 获取当前指针所对应记录的数据（每个字段）
				// 根据字段的顺序获取值
				int id = rs.getInt(1);
				// 根据字段名称获取值
				String name = rs.getString("p_name");
				String link = rs.getString("p_link");
				String type = rs.getString("p_type");
				String num = rs.getString("p_num");
				String location = rs.getString("p_location");
				String publish_time = rs.getString("p_publish_time");
				
				//将值封装到position对象中
				TencentPosition position=new TencentPosition();
				position.setPositionLink(link);
				position.setPositionName(name);
				position.setPositionNum(num);
				position.setPositionType(type);
				position.setPublishTime(publish_time);
				position.setWorkLocation(location);
				
				//将position对象，添加到list
				list.add(position);
			}
			// 关闭所有资源
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
