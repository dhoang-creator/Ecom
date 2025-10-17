// should productId and customerId be their own t

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public record Order(int[] productId, int customerId, Status status) {

}

// the below will be split up eventually
@RestController
public class OrderController {

    @GetMapping("/order")
    public Order order(@RequestParam(// TODO )) {
        // the order logic i.e. access to repository etc should be separated
        // centralised exception handling
    }

}
