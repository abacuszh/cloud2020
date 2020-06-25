package org.aiguigu.springcloud.dao;

import java.util.List;

import org.aiguigu.springcloud.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource(path = "payment")
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	@RestResource(path="serialContains",rel="serialContains")
	public List<Payment> findBySerialContainingOrderByIdDesc(@Param("serial") String serial);
	
}
