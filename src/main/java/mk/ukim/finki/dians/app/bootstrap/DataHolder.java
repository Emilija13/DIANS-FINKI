package mk.ukim.finki.dians.app.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.dians.app.model.Heritage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

@Component
public class DataHolder {
    public static List<Heritage> heritages=new ArrayList<>();

    @PostConstruct
    public void init() {
       // heritages.add(new Heritage("1", "Маркови Кули", "Прилеп", "Археолошко наоѓалиште/Тврдина/Кула", 41.3610558, 21.5394503));
       // heritages.add(new Heritage("2", "Куќата на Мантови", "Прилеп", "Археолошко наоѓалиште/Тврдина/Кула", 41.3557382, 21.5404226));
       // heritages.add(new Heritage("3", "Скупи", "Скопје", "Археолошко наоѓалиште/Тврдина/Кула", 42.0150515, 21.3942891));
    }
}
