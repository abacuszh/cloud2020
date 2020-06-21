package org.aiguigu.springcloud.dao;

import org.aiguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author bbb
 *
 */
@Mapper
public interface PaymentDao {
	
	public int save(Payment payment);
	
	public Payment getPaymentById(@Param("id") Long id);

}
