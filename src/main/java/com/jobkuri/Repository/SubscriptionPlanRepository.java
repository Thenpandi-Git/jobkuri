package com.jobkuri.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobkuri.Entity.SubscriptionPlan;



@Repository
public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan , Long> {


}

