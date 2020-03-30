package cn.bdqn.pojo;
/**
 * 理财产品信息表
 * @author Administrator
 */

import java.util.Date;

public class FinancingProduct {
    private String id;
    private Integer risk;
    private String income;
    private Date saleStarting;
    private Date saleEnd;
    private Date end;
    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Integer getRisk() {
        return risk;
    }
    public void setRisk(Integer risk) {
        this.risk = risk;
    }
    public String getIncome() {
        return income;
    }
    public void setIncome(String income) {
        this.income = income;
    }
    public Date getSaleStarting() {
        return saleStarting;
    }
    public void setSaleStarting(Date saleStarting) {
        this.saleStarting = saleStarting;
    }
    public Date getSaleEnd() {
        return saleEnd;
    }
    public void setSaleEnd(Date saleEnd) {
        this.saleEnd = saleEnd;
    }
    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }


}
