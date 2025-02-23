package com.imooc.cp.dao;

import com.imooc.cp.entity.ClaimVoucher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimVoucherDao {
    void insert(ClaimVoucher claimVoucher);
    void update(ClaimVoucher claimVoucher);
    void delete(int id);
    ClaimVoucher select(int id);
    List<ClaimVoucher> selectByCreateSn(String csn);
    List<ClaimVoucher> selectByNextDealSn(String ndsn);
}
