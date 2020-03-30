package cn.bdqn.dao;

import cn.bdqn.pojo.FinancingProduct;

import java.sql.SQLException;
import java.util.List;

public interface FinancingDao {
    //查询所有的理财信息
    List<FinancingProduct> getFinancingList(String id, String risk) throws SQLException;
    //获取代码的记录数
    int getCountById(String id) throws SQLException;
    //保存理财信息
    int insertFinancing(FinancingProduct product) throws SQLException;
    //查询单个理财信息
    FinancingProduct getFinancingById(String id) throws SQLException;
    //修改
    int updateFinancing(FinancingProduct product) throws SQLException;
    //删除
    int deleteFinancingById(String id) throws SQLException;

}
