package app.dao;

import app.db.DbConnect;
import app.entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
    public void addNewUser (User user) {
        try {
            PreparedStatement ps = DbConnect.getPreparedStatement("insert into users values(null,?, ?)");
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());

            ps.execute();

        } catch(SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<User> getAllUsers() {
        List<User> ls = new LinkedList<User>();

        try {
            ResultSet rs = DbConnect.getPreparedStatement("select * from users").executeQuery();
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


    public static User getUserById(int id){
        User us = new User();
        String sql = "select * from users where id = " +id;
        try {
            ResultSet rs = DbConnect.getPreparedStatement(sql).executeQuery();
            while(rs.next()){
                us = new User(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
        } catch(SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return us;
    }

    public void editUser(int id, String name, int age){
        try {
            String sql = "update users SET name = ?, age = ?" + " where id = ?";
            PreparedStatement ps= DbConnect.getPreparedStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);

            ps.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Boolean deleteUser(int id){
        Boolean sc = true;
        try {
            String sql = "delete from users where id = ?";
            PreparedStatement ps = DbConnect.getPreparedStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            sc = false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sc;
    }

   /* public static void main(String[] args) {
        List<User> lst = getAll();
        for(User i : lst)
        {
            System.out.println(i.getName());
        }

        System.out.println("add !");
        User c1 = new User(2, "vot ona");
        UserDAO da = new UserDAO();
        da.addNew(c1);

        System.out.println("delete!");
        UserDAO da = new UserDAO();
        da.delete(6);


        System.out.println("edit!");
        UserDAO da = new UserDAO();
        da.edit(1, "lamba");

        List<User> lst1 = getAll();
        for(User i : lst1)
        {
            System.out.println(i.getName());
        }
    }*/
}
