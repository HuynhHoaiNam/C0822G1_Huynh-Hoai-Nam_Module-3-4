package com.codegym.repository.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
@Query(value = "select *\n" +
        "from customer\n" +
        "         left join customer_type ct on customer.customer_type_id = ct.id\n" +
        "where customer.name like concat('%', :name, '%')\n" +
        "  and customer.email like concat('%', :email, '%')\n" +
        "  and ct.name like concat('%', :customerType, '%')",nativeQuery = true)
    Page<Customer> showList(@Param("name") String name, @Param("email") String email, @Param("customerType") String customerType,Pageable pageable);

//    @Query(value = "select c.id ,c.name as customerName, c.date_of_birth,c.gender,c.id_card,c.phone_number,c.email,c.address,ct.name as customerTypeName from `customer` c left join `customer_type` ct on c.customer_type_id = ct.id where c.name like concat('%',:nameInput,'%')and c.email like concat('%',:emailInput,'%')  and ct.name like concat('%',:customerNameInput,'%')", nativeQuery = true)
//    Page<Customer> showList(@Param("nameInput") String name, @Param("emailInput") String email, @Param("customerNameInput") String customerType, Pageable pageable);
}
