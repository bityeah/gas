package cn.demo.gas.pay;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

/**
 * Created by huangjp on 2017/7/23.
 */
public class DataInsert {


    public static void main(String[] args) {

        Connection[] conn = new Connection[5];
        PreparedStatement[] prest = new PreparedStatement[5];
        String sql = "insert into recharge? (id, tradeNo, uid, source, `type`, payAccount, state, amount, payTime)" +
                    " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            for (int i = 0; i < 5; i++) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn[i] = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gas" + i, "root", "123456");
                conn[i].setAutoCommit(false);
                prest[i] = conn[i].prepareStatement(sql);
            }

            Random random = new Random();
            int[] p = new int[5];

            for (int j = 1; j < 100000001; j++) {

                int uid = random.nextInt(1000000);
                int i = uid % 5;

                addBatch(j, uid, prest[i]);
                p[i] ++;

                if (p[i] == 10000) {
                    prest[i].executeBatch();
                    conn[i].commit();
                    prest[i].clearBatch();
                    p[i] = 0;
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                for (int i = 0; i < 5; i++) {
                    prest[i].close();
                    conn[i].close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addBatch(long i, int uid, PreparedStatement prest) throws Exception{
        prest.setLong(1,  i % 100);
        prest.setLong(2, i);
        prest.setLong(3, System.nanoTime());
        prest.setInt(4, uid);
        prest.setInt(5, 1);
        prest.setInt(6, 1);
        prest.setString(7, "huangjp.hz@gmail.com");
        prest.setInt(8, 0);
        prest.setBigDecimal(9, BigDecimal.ZERO);
        prest.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
        prest.addBatch();
    }

}
