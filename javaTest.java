import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class javaTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        String URL="jdbc:mysql://127.0.0.1:3306/ChaoTLAB";
        String USER="root";
        String PASSWORD="niubi";
        //1.������������
        Class.forName("com.mysql.jdbc.Driver");
        //2.������ݿ�����
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ飨ʹ��Statement�ࣩ
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from user");
        //4.�������ݿ�ķ��ؽ��(ʹ��ResultSet��)
        while(rs.next()){
            System.out.println(rs.getString("user_name")+" "
                    +rs.getString("user_password"));
        }

        //�ر���Դ
        rs.close();
        st.close();
        conn.close();
    }
}