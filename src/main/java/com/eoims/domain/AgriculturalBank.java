package com.eoims.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class AgriculturalBank implements Serializable {
    private int   id;
    private String   orderno;
    private String   orderdate;
    private String   ordertype;
    private String   useraccount;
    private String   businame;
    private String   marketerp;
    private String   marketname;
    private String   onelevel;
    private String   twolevel;
    private String   threelevel;
    private String   branch;
    private String   goodsmodel;
    private String   goodscode;
    private String   goodsname;
    private int   sellcount;
    private String   userlevel;
    private String   payway;
    private BigDecimal pavobeforeprice;
    private BigDecimal   pavoafterprice;
    private BigDecimal   pavobeforemoney;
    private BigDecimal   pavoaftermoney;
    private BigDecimal   Jdpaymoney;
    private BigDecimal   giftcardpaymoney;
    private BigDecimal   accountbalance;
    private BigDecimal   tpavomoney;
    private BigDecimal   usermeetmoney;
    private BigDecimal   fare;
    private String   paydate;
    private String   outstoredate;
    private String   ordercomdate;
    private String   province;
    private String   city;
    private String   county;
    private String   region;
    private String   serviceline;
    private String   isgive;
    private String   orderstatus;
    private String   accountdate;
    private String   ordercate;
    private String   validflag;
    private BigDecimal   ordermoney;
    private String   parentno;
    private String   contractno;
    private String   chanel;
    private String   chaneldetail;
    private String   settlebilldate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getBusiname() {
        return businame;
    }

    public void setBusiname(String businame) {
        this.businame = businame;
    }

    public String getMarketerp() {
        return marketerp;
    }

    public void setMarketerp(String marketerp) {
        this.marketerp = marketerp;
    }

    public String getMarketname() {
        return marketname;
    }

    public void setMarketname(String marketname) {
        this.marketname = marketname;
    }

    public String getOnelevel() {
        return onelevel;
    }

    public void setOnelevel(String onelevel) {
        this.onelevel = onelevel;
    }

    public String getTwolevel() {
        return twolevel;
    }

    public void setTwolevel(String twolevel) {
        this.twolevel = twolevel;
    }

    public String getThreelevel() {
        return threelevel;
    }

    public void setThreelevel(String threelevel) {
        this.threelevel = threelevel;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getGoodsmodel() {
        return goodsmodel;
    }

    public void setGoodsmodel(String goodsmodel) {
        this.goodsmodel = goodsmodel;
    }

    public String getGoodscode() {
        return goodscode;
    }

    public void setGoodscode(String goodscode) {
        this.goodscode = goodscode;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getSellcount() {
        return sellcount;
    }

    public void setSellcount(int sellcount) {
        this.sellcount = sellcount;
    }

    public String getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(String userlevel) {
        this.userlevel = userlevel;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    public BigDecimal getPavobeforeprice() {
        return pavobeforeprice;
    }

    public void setPavobeforeprice(BigDecimal pavobeforeprice) {
        this.pavobeforeprice = pavobeforeprice;
    }

    public BigDecimal getPavoafterprice() {
        return pavoafterprice;
    }

    public void setPavoafterprice(BigDecimal pavoafterprice) {
        this.pavoafterprice = pavoafterprice;
    }

    public BigDecimal getPavobeforemoney() {
        return pavobeforemoney;
    }

    public void setPavobeforemoney(BigDecimal pavobeforemoney) {
        this.pavobeforemoney = pavobeforemoney;
    }

    public BigDecimal getPavoaftermoney() {
        return pavoaftermoney;
    }

    public void setPavoaftermoney(BigDecimal pavoaftermoney) {
        this.pavoaftermoney = pavoaftermoney;
    }

    public BigDecimal getJdpaymoney() {
        return Jdpaymoney;
    }

    public void setJdpaymoney(BigDecimal jdpaymoney) {
        Jdpaymoney = jdpaymoney;
    }

    public BigDecimal getGiftcardpaymoney() {
        return giftcardpaymoney;
    }

    public void setGiftcardpaymoney(BigDecimal giftcardpaymoney) {
        this.giftcardpaymoney = giftcardpaymoney;
    }

    public BigDecimal getAccountbalance() {
        return accountbalance;
    }

    public void setAccountbalance(BigDecimal accountbalance) {
        this.accountbalance = accountbalance;
    }

    public BigDecimal getTpavomoney() {
        return tpavomoney;
    }

    public void setTpavomoney(BigDecimal tpavomoney) {
        this.tpavomoney = tpavomoney;
    }

    public BigDecimal getUsermeetmoney() {
        return usermeetmoney;
    }

    public void setUsermeetmoney(BigDecimal usermeetmoney) {
        this.usermeetmoney = usermeetmoney;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public String getOutstoredate() {
        return outstoredate;
    }

    public void setOutstoredate(String outstoredate) {
        this.outstoredate = outstoredate;
    }

    public String getOrdercomdate() {
        return ordercomdate;
    }

    public void setOrdercomdate(String ordercomdate) {
        this.ordercomdate = ordercomdate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getServiceline() {
        return serviceline;
    }

    public void setServiceline(String serviceline) {
        this.serviceline = serviceline;
    }

    public String getIsgive() {
        return isgive;
    }

    public void setIsgive(String isgive) {
        this.isgive = isgive;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String getAccountdate() {
        return accountdate;
    }

    public void setAccountdate(String accountdate) {
        this.accountdate = accountdate;
    }

    public String getOrdercate() {
        return ordercate;
    }

    public void setOrdercate(String ordercate) {
        this.ordercate = ordercate;
    }

    public String getValidflag() {
        return validflag;
    }

    public void setValidflag(String validflag) {
        this.validflag = validflag;
    }

    public BigDecimal getOrdermoney() {
        return ordermoney;
    }

    public void setOrdermoney(BigDecimal ordermoney) {
        this.ordermoney = ordermoney;
    }

    public String getParentno() {
        return parentno;
    }

    public void setParentno(String parentno) {
        this.parentno = parentno;
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }

    public String getChanel() {
        return chanel;
    }

    public void setChanel(String chanel) {
        this.chanel = chanel;
    }

    public String getChaneldetail() {
        return chaneldetail;
    }

    public void setChaneldetail(String chaneldetail) {
        this.chaneldetail = chaneldetail;
    }

    public String getSettlebilldate() {
        return settlebilldate;
    }

    public void setSettlebilldate(String settlebilldate) {
        this.settlebilldate = settlebilldate;
    }
}
