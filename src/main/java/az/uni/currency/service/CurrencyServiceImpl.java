package az.uni.currency.service;

import az.uni.currency.dto.CurrencyDTO;
import az.uni.currency.enums.CurrencyEnum;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {


    @Override
    @Cacheable
    public List<CurrencyDTO> getCurrencyRate() {

        CurrencyDTO usdRate = CurrencyDTO.builder()
                .currencyEnum(CurrencyEnum.USD)
                .buyRate(CurrencyServiceImpl.nextDoubleBetween(1.6d, 1.7d))
                .saleRate(CurrencyServiceImpl.nextDoubleBetween(1.7d, 1.9d))
                .dateRate(LocalDateTime.now()).build();

        CurrencyDTO tryRate = CurrencyDTO.builder()
                .currencyEnum(CurrencyEnum.TRY)
                .buyRate(CurrencyServiceImpl.nextDoubleBetween(7.6d, 8.0d))
                .saleRate(CurrencyServiceImpl.nextDoubleBetween(8.0d, 8.5d))
                .dateRate(LocalDateTime.now()).build();
        return List.of(usdRate,tryRate);
    }


    private static BigDecimal nextDoubleBetween(double min, double max) {
        return BigDecimal.valueOf((ThreadLocalRandom.current().nextDouble() * (max - min)) + min);
    }
}
