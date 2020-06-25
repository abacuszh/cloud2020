package org.aiguigu.springcloud.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author bbb
 *
 */
@ApiModel("Payment")
@Entity
public class Payment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -747956862086846330L;

	@ApiModelProperty(value = "ID", example = "1")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	private String serial;

	public Payment() {
		super();
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", serial=" + serial + "]";
	}

	public Payment(Long id, String serial) {
		super();
		this.id = id;
		this.serial = serial;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the serial
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * @param serial the serial to set
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

}
