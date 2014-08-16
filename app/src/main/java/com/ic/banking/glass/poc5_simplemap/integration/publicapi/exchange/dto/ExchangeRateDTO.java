package com.ic.banking.glass.poc5_simplemap.integration.publicapi.exchange.dto;

import com.ic.banking.glass.poc5_simplemap.integration.publicapi.common.api.DestinationCurrencyDTO;
import com.ic.banking.glass.poc5_simplemap.integration.publicapi.common.api.SourceCurrencyDTO;

public class ExchangeRateDTO {

    private SourceCurrencyDTO sourceCurrency;
    private String buyRate;
    private String sellRate;
    private DestinationCurrencyDTO destinationCurrency;
    private String official;

    public SourceCurrencyDTO getSourceCurrencyDTO() {
        return sourceCurrency;
    }

    public void setSourceCurrencyDTO(SourceCurrencyDTO sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(String buyRate) {
        this.buyRate = buyRate;
    }

    public String getSellRate() {
        return sellRate;
    }

    public void setSellRate(String sellRate) {
        this.sellRate = sellRate;
    }

    public DestinationCurrencyDTO getDestinationCurrencyDTO() {
        return destinationCurrency;
    }

    public void setDestinationCurrencyDTO(DestinationCurrencyDTO destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }
}

