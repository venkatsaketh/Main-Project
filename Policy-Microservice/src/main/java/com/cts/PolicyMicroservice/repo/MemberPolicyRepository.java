package com.cts.PolicyMicroservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.PolicyMicroservice.model.MemberPolicy;

@Repository
public interface MemberPolicyRepository extends JpaRepository<MemberPolicy, Integer> 
{
	@Query(value = "select p.benefits from member_policy p where p.p_Id = :policyId and p.m_id = :memberId",nativeQuery = true)
	public  List<String> getBenefits(@Param("policyId") int policyId, @Param("memberId") long memberId);

	@Query(value = "select p.amount_for_benifits from member_policy p where p.p_Id = :policyId and p.m_id = :memberId",nativeQuery = true)
	public int getAmount(@Param("policyId") int policyId, @Param("memberId") long memberId);
	
}
