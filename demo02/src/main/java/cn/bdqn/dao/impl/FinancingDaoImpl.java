package cn.bdqn.dao.impl;

import cn.bdqn.dao.FinancingDao;
import cn.bdqn.pojo.FinancingProduct;
import cn.bdqn.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FinancingDaoImpl implements FinancingDao {

    @Override
    public List<FinancingProduct> getFinancingList(String id, String risk) throws SQLException {
        String sql = "select * from FinancingProduct where 1=1 ";
        if (id != null && !"".equals(id)) {
            sql += " and id like concat('%','" + id + "','%') ";
        }
        if (null != risk && !"".equals(risk)) {
            sql += " and risk = " + risk;
        }
        ResultSet rs = DBUtil.executeQuery(sql);
        List<FinancingProduct> list = new ArrayList<>();
        while (rs.next()) {
            FinancingProduct product = createFinancing(rs);
            list.add(product);
        }
        //rs.close();//关闭rs
        return list;

    }

    private FinancingProduct createFinancing(ResultSet rs) throws SQLException {
        FinancingProduct product = new FinancingProduct();
        product.setId(rs.getString("id"));
        product.setRisk(rs.getInt("risk"));
        product.setIncome(rs.getString("income"));
        product.setSaleStarting(rs.getDate("saleStarting"));
        product.setSaleEnd(rs.getDate("saleEnd"));
        product.setEnd(rs.getDate("end"));
        return product;
    }

    @Override
    public int getCountById(String id) throws SQLException {
        String sql = "select count(1) from FinancingProduct where id=? ";
        ResultSet rs = DBUtil.executeQuery(sql, id);
        int count = -1;
        if (rs.next()) {
            count = rs.getInt("count(1)");
        }
        //rs.close();//这里关闭rs
        return count;
    }

    @Override
    public int insertFinancing(FinancingProduct product) throws SQLException {
        String sql = "insert into FinancingProduct values(?,?,?,?,?,?)";
        return DBUtil.executeUpdate(sql, product.getId(), product.getRisk(), product.getIncome(),
                product.getSaleStarting(), product.getEnd(), product.getSaleEnd());
    }

    @Override
    public FinancingProduct getFinancingById(String id) throws SQLException {
        String sql = "select * from FinancingProduct where id=? ";
        ResultSet rs = DBUtil.executeQuery(sql, id);
        FinancingProduct product = null;
        if (rs.next()) {
            product = createFinancing(rs);
        }
        //rs.close();
        return product;
    }

    @Override
    public int updateFinancing(FinancingProduct product) throws SQLException {
        String sql = "update FinancingProduct set risk=?,income=?," + "saleStarting=?,end=?,saleEnd=? where id=?";
        return DBUtil.executeUpdate(sql, product.getRisk(), product.getIncome(), product.getSaleStarting(),
                product.getEnd(), product.getSaleEnd(), product.getId());
    }

    @Override
    public int deleteFinancingById(String id) throws SQLException {
        String sql = "delete from FinancingProduct where id=?";
        return DBUtil.executeUpdate(sql, id);
    }


}
