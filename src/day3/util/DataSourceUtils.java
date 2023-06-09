package day3.util;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author yi xian
 * @description 工具类 通用，一次性写完直接用
 * @date 2023/6/7 10:06
 */

public class DataSourceUtils {
    //   --- 获得连接池对象 ---- 通常一个程序中只有一个连接池（很占资源）
    // static的属性是只加载一次
    private static final DruidDataSource dataSource = new DruidDataSource();
    static {
        dataSource.setUrl("jdbc:mysql://localhost:3306/suibian?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("jiangfei123");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }
    public static DruidDataSource getDataSource() {
        return dataSource;
    }
}
