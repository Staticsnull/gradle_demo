package cn.bdqn.web;

import cn.bdqn.pojo.FinancingProduct;
import cn.bdqn.service.FinancingService;
import cn.bdqn.service.impl.FinancingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class FinancingServlet extends HttpServlet {
    private FinancingService service = new FinancingServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");
        String path = req.getServletPath();
        if("/index.do".equals(path)) {
            //查询全部
            doFindObjects(req,res);
        }else if("/toAdd.do".equals(path)) {//新增请求
            toAddObject(req,res);
        }else if("/doFindCode.do".equals(path)) {//异步验证代码是否可用
            doFindCode(req,res);
        }else if("/add.do".equals(path)) {//新增操作
            doAddObject(req, res);
        }else if("/toUpdate.do".equals(path)){//修改请求
            toUpdateObject(req,res);
        }else if("/update.do".equals(path)) {//修改操作
            doUpdateObject(req,res);
        }else if("/del.do".equals(path)) {//异步删除
            doDeleteObject(req,res);
        }
    }
    //异步删除
    public void doDeleteObject(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
        String id = req.getParameter("id");
        boolean result = service.removeObject(id);
        //System.out.println(1111);
        //"[{\"result\":\"" + result + "\"
        String json = "[{\"success\":\""+result+"\"}]";
        res.getWriter().print(json);
        res.getWriter().close();
    }
    //修改操作
    public void doUpdateObject(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
        String id = req.getParameter("id");
        String risk = req.getParameter("risk");
        String income = req.getParameter("income");
        String saleStarting = req.getParameter("saleStarting");
        String saleEnd = req.getParameter("saleEnd");
        String end = req.getParameter("end");
        FinancingProduct product = new FinancingProduct();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        product.setId(id);
        product.setRisk(Integer.parseInt(risk));
        product.setIncome(income);
        try {
            product.setSaleStarting(sdf.parse(saleStarting));
            product.setSaleEnd(sdf.parse(saleEnd));
            product.setEnd(sdf.parse(end));
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("时间转换异常");
        }
        if(service.modifyObject(product)) {//成功
            //成功 重定向至查询请求
            res.sendRedirect("index.do");
        }else {//失败
            //失败
            req.getRequestDispatcher("update.jsp").forward(req, res);
        }

    }
    //修改请求
    public void toUpdateObject(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
        String id = req.getParameter("id");
        FinancingProduct product = service.findObjectById(id);
        req.setAttribute("product", product);
        //转发至修改页面
        req.getRequestDispatcher("update.jsp").forward(req, res);
    }
    //新增操作
    public void doAddObject(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
        String id = req.getParameter("id");
        String risk = req.getParameter("risk");
        String income = req.getParameter("income");
        String saleStarting = req.getParameter("saleStarting");
        String saleEnd = req.getParameter("saleEnd");
        String end = req.getParameter("end");
        FinancingProduct  product = new FinancingProduct();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        product.setId(id);
        product.setRisk(Integer.parseInt(risk));
        product.setIncome(income);
        try {
            product.setSaleStarting(sdf.parse(saleStarting));
            product.setSaleEnd(sdf.parse(saleEnd));
            product.setEnd(sdf.parse(end));
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("时间转换异常");
        }
        //保存
        if(service.saveObject(product)) {
            //成功 重定向至查询请求
            res.sendRedirect("index.do");
        }else {
            //失败
            req.getRequestDispatcher("add.jsp").forward(req, res);
        }
    }
    //使用jQuery+ajax 异步验证
    public void doFindCode(HttpServletRequest req,HttpServletResponse res) throws IOException {
        String id = req.getParameter("id");
        boolean isExist = service.isCodeExist(id);
        res.getWriter().print(isExist);
        res.getWriter().close();
    }
    //添加页面
    public void toAddObject(HttpServletRequest req,HttpServletResponse res) throws IOException {
        res.sendRedirect("add.jsp");
    }
    //查询全部
    protected void doFindObjects(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String id = req.getParameter("id");
        String risk = req.getParameter("risk");
        List<FinancingProduct> list = service.findObjects(id, risk);
        req.setAttribute("id", id);
        req.setAttribute("risk", risk);
        req.setAttribute("list", list);
        req.getRequestDispatcher("list.jsp").forward(req, res);
    }

}
