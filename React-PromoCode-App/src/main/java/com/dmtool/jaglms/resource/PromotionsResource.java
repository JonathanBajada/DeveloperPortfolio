package com.dmtool.jaglms.resource;

import com.dmtool.encryption.EncryptionsUtils;
import com.dmtool.jaglms.model.CustomerPromotions;
import com.dmtool.jaglms.repository.PromotionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class PromotionsResource extends EncryptionsUtils {

    @Autowired
    PromotionsRepository promotionsRepository;

    @PostMapping("/customerPromo")
    public List<CustomerPromotions> retrievePromoData(@RequestBody CustomerPromotions customerPromotions) {
        List<CustomerPromotions> custPromo = promotionsRepository.findByPromoCode(customerPromotions.getPromoCode());
        String ssn = promotionsRepository.decryptSSN(custPromo.get(0).getSsn());
        customerPromotions = custPromo.get(0);
        customerPromotions.setConvertedSSN(ssn);
        custPromo.set(0, customerPromotions);
        return promotionsRepository.findByPromoCode(customerPromotions.getPromoCode());
    }


}
