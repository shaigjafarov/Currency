package az.uni.currency.dto;


import az.uni.currency.enums.CurrencyEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencyDTO {

    private CurrencyEnum currencyEnum;
    private BigDecimal buyRate;
    private BigDecimal saleRate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateRate;



}
