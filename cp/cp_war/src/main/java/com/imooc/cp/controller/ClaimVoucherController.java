package com.imooc.cp.controller;

import com.imooc.cp.biz.ClaimVoucherBiz;
import com.imooc.cp.dto.ClaimVoucherInfo;
import com.imooc.cp.entity.DealRecord;
import com.imooc.cp.entity.Employee;
import com.imooc.cp.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/claim_voucher")
public class ClaimVoucherController {
    @Autowired
    private ClaimVoucherBiz claimVoucherBiz;

    @RequestMapping("/to_add")
    public String to_add(Map<String,Object> map){
        map.put("items", Contant.getItems());
        map.put("info",new ClaimVoucherInfo());
        return "claim_voucher_add";
    }
    @RequestMapping("/add")
    public String add(HttpSession session,ClaimVoucherInfo claimVoucherInfo){
        Employee employee = (Employee) session.getAttribute("employee");
        claimVoucherInfo.getClaimVoucher().setCreateSn(employee.getSn());
        claimVoucherBiz.save(claimVoucherInfo.getClaimVoucher(),claimVoucherInfo.getItems());
        return "redirect:deal";
    }
    @RequestMapping("/deal")
    public String deal(HttpSession session, Map<String,Object> map){
        Employee employee = (Employee) session.getAttribute("employee");
        map.put("list",claimVoucherBiz.getForDeal(employee.getSn()));
        return "claim_voucher_deal";

    }
    @RequestMapping("/self")
    public String self(HttpSession session,Map<String,Object> map){
        Employee employee = (Employee) session.getAttribute("employee");
        map.put("list",claimVoucherBiz.getForSelf(employee.getSn()));
        return "claim_voucher_self";
    }
    @RequestMapping("/detail")
    public String detail(Integer id,Map<String,Object> map){
        map.put("claimVoucher",claimVoucherBiz.get(id));
        map.put("items",claimVoucherBiz.getItems(id));
        map.put("records",claimVoucherBiz.getRecords(id));
        return "claim_voucher_detail";
    }
    @RequestMapping("/to_update")
    public String to_update(Integer id,Map<String,Object> map){
        map.put("items", Contant.getItems());
        ClaimVoucherInfo info =new ClaimVoucherInfo();
        info.setClaimVoucher(claimVoucherBiz.get(id));
        info.setItems(claimVoucherBiz.getItems(id));
        map.put("info",info);
        return "claim_voucher_update";
    }
    @RequestMapping("/update")
    public String update(HttpSession session,ClaimVoucherInfo info){
        Employee employee = (Employee)session.getAttribute("employee");
        info.getClaimVoucher().setCreateSn(employee.getSn());
        claimVoucherBiz.update(info.getClaimVoucher(),info.getItems());
        return "redirect:deal";
    }
    @RequestMapping("/submit")
    public String submit(int id){
        claimVoucherBiz.submit(id);
        return "redirect:deal";
    }
    @RequestMapping("/to_check")
    public String toCheck(int id,Map<String,Object> map){
        map.put("claimVoucher",claimVoucherBiz.get(id));
        map.put("items",claimVoucherBiz.getItems(id));
        map.put("records",claimVoucherBiz.getRecords(id));
        DealRecord dealRecord =new DealRecord();
        dealRecord.setClaimVoucherId(id);
        map.put("record",dealRecord);
        return "claim_voucher_check";
    }
    @RequestMapping("/check")
    public String check(HttpSession session, DealRecord dealRecord){
        Employee employee = (Employee)session.getAttribute("employee");
        dealRecord.setDealSn(employee.getSn());
        claimVoucherBiz.deal(dealRecord);
        return "redirect:deal";
    }
}
