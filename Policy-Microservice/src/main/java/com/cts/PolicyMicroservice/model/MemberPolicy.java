package com.cts.PolicyMicroservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member_policy")
public class MemberPolicy 
{
     @Id
     private int mp_id;
     private int p_id;
     private long m_id;
     private Date sub_date;
     private int tenure;
     private String benefits;
     private int amount_for_benifits;
	public int getMp_id() {
		return mp_id;
	}
	public void setMp_id(int mp_id) {
		this.mp_id = mp_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public long getM_id() {
		return m_id;
	}
	public void setM_id(long m_id) {
		this.m_id = m_id;
	}
	public Date getSub_date() {
		return sub_date;
	}
	public void setSub_date(Date sub_date) {
		this.sub_date = sub_date;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public String getBenefits() {
		return benefits;
	}
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}
	public int getAmount_for_benifits() {
		return amount_for_benifits;
	}
	public void setAmount_for_benifits(int amount_for_benifits) {
		this.amount_for_benifits = amount_for_benifits;
	}
	@Override
	public String toString() {
		return "MemberPolicy [mp_id=" + mp_id + ", p_id=" + p_id + ", m_id=" + m_id + ", sub_date=" + sub_date
				+ ", tenure=" + tenure + ", benefits=" + benefits + ", amount_for_benifits=" + amount_for_benifits
				+ "]";
	}
	public MemberPolicy(int mp_id, int p_id, int m_id, Date sub_date, int tenure, String benefits,
			int amount_for_benifits) {
		super();
		this.mp_id = mp_id;
		this.p_id = p_id;
		this.m_id = m_id;
		this.sub_date = sub_date;
		this.tenure = tenure;
		this.benefits = benefits;
		this.amount_for_benifits = amount_for_benifits;
	}
	public MemberPolicy() {
		super();
	}
     
     
}
