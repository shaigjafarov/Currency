package az.uni.currency;

import az.uni.currency.dto.CurrencyDTO;
import az.uni.currency.service.CurrencyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
     private  final CurrencyService currencyService;

    @GetMapping
    List<CurrencyDTO> getCurrency(){
       return currencyService.getCurrencyRate();

    }
}
