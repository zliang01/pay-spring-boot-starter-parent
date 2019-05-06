package com.egzosn.pay.spring.boot.core.merchant.bean;

import com.egzosn.pay.ali.api.AliPayConfigStorage;
import com.egzosn.pay.spring.boot.core.PayConfigurerAdapter;
import com.egzosn.pay.spring.boot.core.builders.InMemoryMerchantDetailsServiceBuilder;
import com.egzosn.pay.spring.boot.core.builders.MerchantDetailsServiceBuilder;
import com.egzosn.pay.spring.boot.core.merchant.PaymentPlatform;
import com.egzosn.pay.spring.boot.core.merchant.PaymentPlatformMerchantDetails;
import com.egzosn.pay.spring.boot.provider.merchant.platform.AliPaymentPlatform;
import com.egzosn.pay.spring.boot.provider.merchant.platform.PaymentPlatforms;

/**
 * 支付宝商户信息列表
 *
 * @author egan
 *         <pre>
 *                 email egzosn@gmail.com
 *                 date   2019/4/6 14:30.
 *                 </pre>
 */
public class AliMerchantDetails extends AliPayConfigStorage implements PaymentPlatformMerchantDetails, PayConfigurerAdapter<InMemoryMerchantDetailsServiceBuilder> {


    private String detailsId;

    private InMemoryMerchantDetailsServiceBuilder builder;

    /**
     * 外部调用者使用，链式的做法
     *
     * @return 返回对应外部调用者
     */
    @Override
    public InMemoryMerchantDetailsServiceBuilder and() {
        return builder;
    }

    public AliMerchantDetails(InMemoryMerchantDetailsServiceBuilder builder) {
        this();
        this.builder = builder;
    }

    public AliMerchantDetails() {
        setPayType(AliPaymentPlatform.platformName);
    }

    /**
     * 获取支付平台
     *
     * @return 支付平台
     */
    @Override
    public PaymentPlatform getPaymentPlatform() {
        return PaymentPlatforms.getPaymentPlatform(getPayType());
    }

    public void setDetailsId(String detailsId) {
        this.detailsId = detailsId;
    }

    /**
     * 获取支付商户id
     *
     * @return 支付商户id
     */
    @Override
    public String getDetailsId() {
        return detailsId;
    }

    public AliMerchantDetails detailsId(String detailsId) {
        this.detailsId = detailsId;
        return this;
    }

    public AliMerchantDetails notifyUrl(String notifyUrl) {
        setNotifyUrl(notifyUrl);
        return this;
    }

    public AliMerchantDetails returnUrl(String returnUrl) {
        setReturnUrl(returnUrl);
        return this;
    }

    public AliMerchantDetails signType(String signType) {
        setSignType(signType);
        return this;
    }

    public AliMerchantDetails inputCharset(String inputCharset) {
        setInputCharset("utf-8");
        return this;
    }

    public AliMerchantDetails test(boolean test) {
        setTest(test);
        return this;
    }

    public AliMerchantDetails pid(String pid) {
        setPid(pid);
        return this;
    }

    public AliMerchantDetails appid(String appid) {
        setAppid(appid);
        return this;
    }

    public AliMerchantDetails keyPrivate(String keyPrivate) {
        setKeyPrivate(keyPrivate);
        return this;
    }

    public AliMerchantDetails keyPublic(String keyPublic) {
        setKeyPublic(keyPublic);
        return this;
    }

    public AliMerchantDetails seller(String seller) {
        setSeller(seller);
        return this;
    }


}