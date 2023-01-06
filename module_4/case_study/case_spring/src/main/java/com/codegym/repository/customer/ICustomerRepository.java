package com.codegym.repository.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
//@Query(value = "select *\n" +
//        "from customer\n" +
//        "         left join customer_type ct on customer.customer_type_id = ct.id\n" +
//        "where customer.name like concat('%', :name, '%')\n" +
//        "  and customer.email like concat('%', :email, '%')\n" +
//        "  and ct.name like concat('%', :customerType, '%')",nativeQuery = true)
//    Page<Customer> showList(@Param("name") String name, @Param("email") String email, @Param("customerType") String customerType,Pageable pageable);

    @Query(value = "select *\n" +
            "from customer\n" +
            "where name like concat('%', :name, '%')\n" +
            "  and email like concat('%', :email, '%')\n" +
            "  and customer_type_id = ?;", nativeQuery = true)
    Page<Customer> showList(@Param("nameInput") String name, @Param("emailInput") String email, @Param("customerNameInput") String customerType, Pageable pageable);


    @Query(value = "select *\n" +
            "from customer\n" +
            "where name like concat('%', :name, '%')\n" +
            "  and email like concat('%', :email, '%')", nativeQuery = true)
    Page<Customer> showListNoId(@Param("nameInput") String name, @Param("emailInput") String email, Pageable pageable);

}
