package org.hwh.customer.service;


import org.hwh.customer.dphelp.DatabaseHelper;
import org.hwh.customer.model.Customer;
import org.hwh.customer.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.transform.ErrorListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CustomerService {
    private  static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    static {
        Properties conf= PropsUtil.loadProps("config.properties");
        DRIVER=conf.getProperty("jdbc.driver");
        URL=conf.getProperty("jdbc.url");
        USERNAME=conf.getProperty("jdbc.username");
        PASSWORD=conf.getProperty("jdbc.password");
        try {
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
           LOGGER.error("can not load jdbc driver",e);
        }
    }


   /* public List<Customer> getCustomerList(){
        Connection conn=null;
        List<Customer> customerList=new ArrayList<Customer>();
        try {

            String sql="select * from customer";
            conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            PreparedStatement stmt=conn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                Customer customer=new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));
                customerList.add(customer);
            }
            return customerList;
        }catch (Exception e){
            LOGGER.error("execute sql failure",e);

        }finally {
            if (conn != null) {
                try {
                    conn.close();
                }catch (SQLException e){
                    LOGGER.error("close connection failure",e);
                }
            }
        }
        return  customerList;
    }*/

  /* public List<Customer> getCustomerList(){
       Connection conn= DatabaseHelper.getConnection();
       try {
           String sql="select * from customer";
          return DatabaseHelper.queryEntityList(Customer.class,conn,sql);
       }finally {
           DatabaseHelper.closeConnection(conn);
       }
   }*/

  public List<Customer> getCustomerList(){
      String sql="select * from customer";
      return DatabaseHelper.queryEntityList(Customer.class,sql);
  }


  /*  public List<Customer> getCustomerList(String keyword){
        return null;
    }*/
    public Customer getCustomer(long id){
        return null;
    }
    public boolean createCustomer(Map<String,Object> fieldMap){
      return DatabaseHelper.inserEntity(Customer.class,fieldMap);
    }
    public boolean updateCustomer(long id,Map<String,Object> fieldMap){
        return DatabaseHelper.updateEntity(Customer.class,id,fieldMap);
    }
    public boolean deleteCustomer(long id){
        return DatabaseHelper.deleteEntity(Customer.class,id);
    }

}
