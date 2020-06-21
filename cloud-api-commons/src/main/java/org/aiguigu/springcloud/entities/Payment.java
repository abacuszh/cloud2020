package org.aiguigu.springcloud.entities;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author bbb
 *
 */
@ApiModel("Payment")
public class Payment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -747956862086846330L;

	@ApiModelProperty(value = "ID", example = "1")
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
