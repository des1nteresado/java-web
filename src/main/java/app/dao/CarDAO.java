package app.dao;

import app.db.DbConnect;
import app.entities.Car;
import app.entities.User;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarDAO {
    public void addNewCar (Car car) {
        try {
            PreparedStatement ps = DbConnect.getPreparedStatement("insert into cars values(null,?, ?)");
            ps.setString(1, car.getName());
            ps.setInt(2, car.getUser_id());
            ps.execute();

        } catch(SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Car> getAllCars() {
        List<Car> ls = new LinkedList<Car>();
        try {
            ResultSet rs = DbConnect.getPreparedStatement("select c.car_id, c.name, c.user_id, u.name as u_name_id from users u join cars c on c.user_id = u.id;").executeQuery();
            while(rs.next())
            {
                Car c = new Car(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                ls.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ls;
    }

    public static Car getCarById(int id){
        Car us = new Car();
        String sql = "select * from cars where car_id = " + id;
        try {
            ResultSet rs = DbConnect.getPreparedStatement(sql).executeQuery();
            while(rs.next()){
                us = new Car(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
        } catch(SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return us;
    }

    public void editCar(int id, String name, int user_id){
        try {
            String sql = "update cars SET name = ?, user_id = ?" + " where car_id = ?";
            PreparedStatement ps= DbConnect.getPreparedStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, user_id);
            ps.setInt(3, id);
            ps.executeUpdate();

        } catch(SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void deleteCar(int id){
        try {
            String sql = "delete from cars where car_id = ?";
            PreparedStatement ps = DbConnect.getPreparedStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


 /*   public static void main(String[] args) {
        List<Car> lst = getAll();
        for(Car i : lst)
        {
            System.out.println(i.getName());
        }

      *//*  System.out.println("add !");
        Car c1 = new Car(2, "vot ona");
        CarDAO da = new CarDAO();
        da.addNew(c1);
*//*
        System.out.println("delete!");
        CarDAO da = new CarDAO();
        da.delete(5);


      *//*  System.out.println("edit!");
        da.edit(1, "lamba", 1);*//*

        List<Car> lst1 = getAll();
        for(Car i : lst1)
        {
            System.out.println(i.getName());
        }
    }*/
}
