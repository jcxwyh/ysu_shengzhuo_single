package pro.onlyou.shengzhuo.common.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MySQLTest {

    private Connection connection = null;

    @BeforeAll
    public void before(){
        try{
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shengzhuo","shengzhuo","AaronJiangShengZhuo2013#");

        }catch (Exception e){
            log.error("初始化MySQL数据库链接异常！");
            System.out.println(e);
        }
    }

    @Test
    public void testConn(){
        Assertions.assertNotNull(connection);
        System.out.println(connection);
        System.out.println(log.getClass());
    }

}
