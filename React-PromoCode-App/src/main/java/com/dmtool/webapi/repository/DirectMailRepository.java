package com.dmtool.webapi.repository;

import com.dmtool.webapi.model.DirectMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectMailRepository extends JpaRepository<DirectMail, Integer> {
    List<DirectMail> findByPromoCodeOrEmail (String promoCode, String email);
    List<DirectMail> findByEmail (String email);
}
