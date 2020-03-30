package cn.bdqn.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 * 封装数据库的连接 关闭 回滚操作
 * @author Administrator
 *
 */
public class DBUtil {
    //定义静态对象
    private static String url;
    private static String driver;
    private static String user;
    private static String pwd;
    //读取配置文件
    static {
        Properties properties = new Properties();
        //加载驱动
        try {
            InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("配置文件找不到!");
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        pwd = properties.getProperty("password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw  new RuntimeException("找不到驱动类");
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pwd);
    }
    //关闭连接
    public static void close(Connection conn,ResultSet rs,PreparedStatement ps) {
        if(null != rs) {
            try {
                rs.close();
                rs = null;//GC回收
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != ps) {
            try {
                ps.close();
                ps = null;//GC回收
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != conn) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void rollback(Connection conn) {
        if(null != conn) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection conn) {
        if(null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //封装查询的方法
    public static ResultSet executeQuery(String sql,Object... params) {
        try(Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            if(null != params) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1, params[i]);
                }
            }
            ResultSet rs =  ps.executeQuery();
            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.populate(rs);
            return rowSet;
        }catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询失败!");
        }
    }
    //封装增删改方法
    public static int executeUpdate(String sql,Object... params) {
        try(Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            if(null != params) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1, params[i]);
                }
            }
            //返回影响行数
            return ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("增删改操作失败!");
        }
    }

}
