import java.sql.SQLException;
import java.sql.*;

import java.util.Scanner;
public class TransactionDemo {
    private static final String url="jdbc:mysql://localhost:3306/mydb";
    private static final String user="root";
    private static final String password="@Sagar123";
    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con=DriverManager.getConnection(url,user,password);
            con.setAutoCommit(false);
            String debit_query="update account set balance=balance-? where accountNumber=?";
            String credit_query="update account set balance=balance+? where accountNumber=?";
            PreparedStatement ps1=con.prepareStatement(debit_query);
            PreparedStatement ps2=con.prepareStatement(credit_query);

            Scanner sc=new Scanner(System.in);
            System.out.println("Enter amount to send");
            int amount=sc.nextInt();

            System.out.println("enter your account number");

            String accNum=sc.next();

            System.out.println("enter sender account number");
            String senderAccNum=sc.next();




            ps1.setInt(1,amount);
            ps1.setString(2,accNum);

            ps2.setInt(1,amount);
            ps2.setString(2,senderAccNum);

            if(isSufficientBalance(con,accNum,amount)){
                ps1.executeUpdate();
                ps2.executeUpdate();

                con.commit();

            }else{
                con.rollback();
                System.out.println("Transaction failed");
            }









        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    static boolean isSufficientBalance(Connection con,String accNum,int amount){
        try{
            String query="select balance from account where accountNumber=?";
            PreparedStatement ps=con.prepareStatement(query);

            ps.setString(1,accNum);

            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int balance=rs.getInt("balance");
                if(balance>=amount){
                    return true;
                }
                else{
                    return false;
                }
            }


        }catch(SQLException e){
            System.out.println(e.getMessage());
        }


        return false;


    }
}
