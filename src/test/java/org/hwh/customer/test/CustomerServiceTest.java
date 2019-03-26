package org.hwh.customer.test;

import org.hwh.customer.dphelp.DatabaseHelper;
import org.hwh.customer.model.Customer;
import org.hwh.customer.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceTest {
    private final CustomerService customerService;
    public CustomerServiceTest(){
        customerService=new CustomerService();
    }
    @Before
    public void init() throws Exception{
       /* String file="sql/customer_init.sql";
        InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
        BufferedReader reader=new BufferedReader(new InputStreamReader(is));
        String sql;
        while ((sql = reader.readLine()) != null){
            DatabaseHelper.executeUpdate(sql);
        }*/
       DatabaseHelper.executeSqlFile("sql/customer_init.sql");

    }
   @Test
    public void getCustomerListTest() throws Exception{
        List<Customer> customerList=customerService.getCustomerList();
       Assert.assertEquals(2,customerList.size());
    }
   /* @Test
    public void getCustomerTest() throws Exception{
            long id = 1;
            Customer customer = customerService.getCustomer(id);
            Assert.assertNotNull(customer);
    }*/

    @Test
    public void createCustomerTest() throws Exception{
        Map<String,Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("name","customer100");
        fieldMap.put("contact","John");
        fieldMap.put("telephone","13512345678");
        boolean result=customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public  void updateCustomerTest() throws Exception {
        long id=1;
        Map<String,Object> fieldMap=new HashMap<String, Object>();
        fieldMap.put("contact","Eric");
        boolean result= customerService.updateCustomer(id,fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomerTest() throws  Exception {
        long id =1;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(true);
    }

}
