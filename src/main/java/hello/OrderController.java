package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private static final String template = "OrderNo, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/order")
    public Order ordering(@RequestParam(value="documentno", defaultValue="ORDER/ 1") String documentNo) {
        return new Order(counter.incrementAndGet(),
                            String.format(template, documentNo));
    }
}