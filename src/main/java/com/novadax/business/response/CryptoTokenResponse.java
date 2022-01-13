package com.novadax.business.response;

import java.io.Serializable;

public class CryptoTokenResponse implements Serializable {

    private String codeAccount;
    private String chainAlias;
    private String chainName;
    private String codeToken;
    private String mainAddr;
    private Integer useMemo;
    private Integer useDynamicSendFee;
    private Integer minConf;
    private Integer useFirst;
    private Integer showOrder;
    private Integer state;
    private String chainURL;
    private String chainAddressURL;
    private String chainHashURL;
    private String officialURL;

    public String getCodeAccount() {
        return codeAccount;
    }

    public void setCodeAccount(String codeAccount) {
        this.codeAccount = codeAccount;
    }

    public String getChainAlias() {
        return chainAlias;
    }

    public void setChainAlias(String chainAlias) {
        this.chainAlias = chainAlias;
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

    public String getCodeToken() {
        return codeToken;
    }

    public void setCodeToken(String codeToken) {
        this.codeToken = codeToken;
    }

    public String getMainAddr() {
        return mainAddr;
    }

    public void setMainAddr(String mainAddr) {
        this.mainAddr = mainAddr;
    }

    public Integer getUseMemo() {
        return useMemo;
    }

    public void setUseMemo(Integer useMemo) {
        this.useMemo = useMemo;
    }

    public Integer getUseDynamicSendFee() {
        return useDynamicSendFee;
    }

    public void setUseDynamicSendFee(Integer useDynamicSendFee) {
        this.useDynamicSendFee = useDynamicSendFee;
    }

    public Integer getMinConf() {
        return minConf;
    }

    public void setMinConf(Integer minConf) {
        this.minConf = minConf;
    }

    public Integer getUseFirst() {
        return useFirst;
    }

    public void setUseFirst(Integer useFirst) {
        this.useFirst = useFirst;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getChainURL() {
        return chainURL;
    }

    public void setChainURL(String chainURL) {
        this.chainURL = chainURL;
    }

    public String getChainAddressURL() {
        return chainAddressURL;
    }

    public void setChainAddressURL(String chainAddressURL) {
        this.chainAddressURL = chainAddressURL;
    }

    public String getChainHashURL() {
        return chainHashURL;
    }

    public void setChainHashURL(String chainHashURL) {
        this.chainHashURL = chainHashURL;
    }

    public String getOfficialURL() {
        return officialURL;
    }

    public void setOfficialURL(String officialURL) {
        this.officialURL = officialURL;
    }
}
