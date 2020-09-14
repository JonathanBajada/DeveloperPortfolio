package com.dmtool.jaglms.repository;

import com.dmtool.jaglms.model.CustomerPromotions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionsRepository extends JpaRepository<CustomerPromotions, Integer>
{

    @Query(value = "Select * from jaglms.mk_customer_promotions where promo_code = ?1" , nativeQuery = true)
    List<CustomerPromotions> findByPromoCode (String promoCode);

    @Query(value = "Select CONVERT ((aes_decrypt(?1, sha('109480123k0asdojf2309434joweg0oijdf0oitqqq'))) USING utf8)" , nativeQuery = true)
    String decryptSSN(Byte[] ssn);

}
