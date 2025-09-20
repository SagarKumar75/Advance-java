import java.sql.*;
import java.util.*;
public class JdbcDemo {

    private static final String url="jdbc:mysql://localhost:3306/mydb";
    private static final String user="root";
    private static final String password="@Sagar123";

    public static void main(String[] args) {
        try{
            // 1: Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());

        }

        try{

            // 2. Establish connection
            Connection con=DriverManager.getConnection(url,user,password);

            // 3. create statement
//           Statement stmt=con.createStatement();

            // query for sql

//           String query="select * from Student";   // retrieval query

            // 4. execute query using statement

//           ResultSet rs=stmt.executeQuery(query);  // executeQuery is used only for select statement

            // 5. retrieve all the data

//           while(rs.next()){
//               String name=rs.getString("name");
//               int age=rs.getInt("age");
//               System.out.println("name: "+name);
//               System.out.println("age: "+age);
//           }


            // insertion query using statement

//           String query=String.format("insert into Student(id,name,age) values(%o,'%s',%o)",2,"rohan",23);
//
//           int rowAffected=stmt.executeUpdate(query);  // executeUpdate is used with except select statement.
//
//           if(rowAffected>0){
//               System.out.println("data inserted successfully");
//           }else{
//               System.out.println("data not inserted");
//           }

//           // updation query using statement
//
//           String query=String.format("update Student set name='%s' where id=%o","Sonali",2);
//
//           int rowAffected=stmt.executeUpdate(query);  // executeUpdate is used with except select statement.
//
//           if(rowAffected>0){
//               System.out.println("data updated successfully");
//           }else{
//               System.out.println("data not updated");
//           }

            // deletion query using statement

//           String query=String.format("delete from Student where id=%o",2);
//
//           int rowAffected=stmt.executeUpdate(query);
//           if(rowAffected>0){
//               System.out.println("data deleted successfully");
//           }else{
//               System.out.println("data not deleted");
//           }



            // important : we are now going to use preparedStatement
//           String query="select * from Student";
//
//           PreparedStatement ps=con.prepareStatement(query);

//           ResultSet rs=ps.executeQuery();  // retrieving
//
//           while(rs.next()){
//               int id=rs.getInt("id");
//               String name=rs.getString("name");
//               int age=rs.getInt("age");
//
//               System.out.println("id: "+id);
//               System.out.println("name: "+name);
//               System.out.println("age: "+age);
//           }


            // insertion
//           String query="insert into Student (id,name,age) values(?,?,?)";
//
//           PreparedStatement ps=con.prepareStatement(query);
//
//           ps.setInt(1,2);
//           ps.setString(2,"Neha");
//           ps.setInt(3,40);
//
//           int rowsAffected=ps.executeUpdate();
//           if(rowsAffected>0){
//               System.out.println(rowsAffected+" rows affected");
//
//           }else{
//               System.out.println(rowsAffected+" rows not affected");
//           }

            // updation

//           String query="update Student set age=? where id=?";
//
//           PreparedStatement ps=con.prepareStatement(query);
//
//           ps.setInt(1,24);
//           ps.setInt(2,2);
//
//
//           int rowsAffected=ps.executeUpdate();
//           if(rowsAffected>0){
//               System.out.println(rowsAffected+" rows affected");
//
//           }else{
//               System.out.println(rowsAffected+" rows not affected");
//           }


            //deletion
//
//           String query="delete from Student where id=?";
//
//           PreparedStatement ps=con.prepareStatement(query);
//
//           ps.setInt(1,2);
//
//
//           int rowsAffected=ps.executeUpdate();
//           if(rowsAffected>0){
//               System.out.println(rowsAffected+" rows affected");
//
//           }else{
//               System.out.println(rowsAffected+" rows not affected");
//           }


            // Batch Processing  :   important features

            // using statement

//           Statement stmt=con.createStatement();
//           Scanner sc=new Scanner(System.in);
//
//           while(true){
//               System.out.print("Enter your id ");
//               int id=sc.nextInt();
//               sc.nextLine();
//               System.out.print("Enter your name ");
//               String name=sc.nextLine();
//               System.out.print("Enter your age ");
//               int age=sc.nextInt();
//
//               String query=String.format("insert into Student (id,name,age) values(%d, '%s', %d)",id,name,age);
//
//               stmt.addBatch(query);
//
//               System.out.print("You want to add more data, if yes type Y else type N");
//               String choice=sc.next();
//
//               if(choice.toUpperCase().equals("N")){
//                   break;
//               }
//
//           }
//
//           int [] response=stmt.executeBatch();
//
//           for(int i=0;i<response.length;i++){
//               if(response[i]==1){
//                   System.out.println("response "+i+" is successfully executed");
//               }else{
//                   System.out.println("response "+i+" is failed");
//               }
//           }


            // using preparedStatement
            String query="insert into Student (id,name,age) values(?,?,?)";

            PreparedStatement ps=con.prepareStatement(query);

            Scanner sc=new Scanner(System.in);

            while(true){
                System.out.print("Enter your id ");
                int id=sc.nextInt();
                sc.nextLine();
                System.out.print("Enter your name ");
                String name=sc.nextLine();
                System.out.print("Enter your age ");
                int age=sc.nextInt();


                ps.setInt(1,id);
                ps.setString(2,name);
                ps.setInt(3,age);

                ps.addBatch();

                System.out.print("You want to add more data, if yes type Y else type N");
                String choice=sc.next();

                if(choice.toUpperCase().equals("N")){
                    break;
                }

            }

            int [] response=ps.executeBatch();

            for(int i=0;i<response.length;i++){
                if(response[i]==1){
                    System.out.println("response "+i+" is successfully executed");
                }else{
                    System.out.println("response "+i+" is failed");
                }
            }



            con.close();
            sc.close();
            ps.close();














        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
