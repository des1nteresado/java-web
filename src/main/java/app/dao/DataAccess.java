package app.dao;

import app.db.DBUtils;
import app.entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccess {
    public void addNew (User user) {
        try {
            PreparedStatement ps = DBUtils.getPreparedStatement("insert into users values(null,?, ?)");
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());

            ps.execute();

        } catch(SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<User> getAll() {
        List<User> ls = new LinkedList<User>();

        try {
            ResultSet rs = DBUtils.getPreparedStatement("select * from users").executeQuery();
            while(rs.next())
            {
                User c = new User(rs.getInt(1), rs.getString(2), rs.getInt(3));
                ls.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ls;
    }


    public static List<User> getUserById(int id){
        List<User> ls = new LinkedList<User>();
        String sql = "select * from users where id = " +id;
        try {
            ResultSet rs = DBUtils.getPreparedStatement(sql).executeQuery();
            while(rs.next()){
                User c = new User(rs.getInt(1), rs.getString(2), rs.getInt(3));

                ls.add(c);
            }
        } catch(SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return ls;
    }

    public void edit(int id, String name, int age){
        try {
            String sql = "update users SET name = ?, age = ?" + " where id = ?";
            PreparedStatement ps= DBUtils.getPreparedStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);

            ps.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id){
        try {
            String sql = "delete from users where id = ?";
            PreparedStatement ps = DBUtils.getPreparedStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   /* public static void main(String[] args) {
        List<User> lst = getAll();
        for(User i : lst)
        {
            System.out.println(i.getName());
        }

        System.out.println("add !");
        User c1 = new User(2, "vot ona");
        DataAccess da = new DataAccess();
        da.addNew(c1);

        System.out.println("delete!");
        DataAccess da = new DataAccess();
        da.delete(6);


        System.out.println("edit!");
        DataAccess da = new DataAccess();
        da.edit(1, "lamba");

        List<User> lst1 = getAll();
        for(User i : lst1)
        {
            System.out.println(i.getName());
        }
    }*/
}
