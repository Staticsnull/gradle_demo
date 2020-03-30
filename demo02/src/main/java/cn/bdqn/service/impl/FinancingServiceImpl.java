package cn.bdqn.service.impl;

import cn.bdqn.dao.FinancingDao;
import cn.bdqn.dao.impl.FinancingDaoImpl;
import cn.bdqn.pojo.FinancingProduct;
import cn.bdqn.service.FinancingService;

import java.sql.SQLException;
import java.util.List;

public class FinancingServiceImpl implements FinancingService {
    private FinancingDao dao = new FinancingDaoImpl();
    @Override
    public List<FinancingProduct> findObjects(String id, String risk) {
        try{
            return dao.getFinancingList(id, risk);
        }catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询代码异常");
        }
    }
    @Override
    public boolean isCodeExist(String id) {
        try{
            return dao.getCountById(id)>0;
        }catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询代码异常");
        }
    }
    @Override
    public boolean saveObject(FinancingProduct product) {
        try{
            //FinancingDao dao = new FinancingDaoImpl(conn);
            return dao.insertFinancing(product)>0;
        }catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("保存异常");
        }
    }
    @Override
    public FinancingProduct findObjectById(String id) {
        try{
            return dao.getFinancingById(id);
        }catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询代码异常");
        }
    }
    @Override
    public boolean modifyObject(FinancingProduct product) {
        try{
            return dao.updateFinancing(product) > 0;
        }catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("修改异常");
        }
    }
    @Override
    public boolean removeObject(String id) {
        try {
            return dao.deleteFinancingById(id) > 0;
        } catch (SQLException e) {
            //DBUtil.rollback(conn);//回滚事务
            e.printStackTrace();
            throw new RuntimeException("修改异常");
        }
    }
}
