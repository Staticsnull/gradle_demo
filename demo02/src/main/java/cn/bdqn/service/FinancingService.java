package cn.bdqn.service;

import cn.bdqn.pojo.FinancingProduct;

import java.util.List;

public interface FinancingService {
    /**
     * 查询所有的理财信息
     * @param id
     * @param risk
     * @return
     */
    List<FinancingProduct> findObjects(String id, String risk);
    /**
     * 判断代码是否存在
     * @param id
     * @return
     */
    boolean isCodeExist(String id);
    /**
     * 保存理财信息
     * @param product
     * @return
     */
    boolean saveObject(FinancingProduct product);
    /**
     * 根据id查询理财信息 用来填充到修改页面
     * @param id
     * @return
     */
    FinancingProduct findObjectById(String id);

    /**
     * 修改
     * @param product
     * @return
     */
    boolean modifyObject(FinancingProduct product);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean removeObject(String id);
}
