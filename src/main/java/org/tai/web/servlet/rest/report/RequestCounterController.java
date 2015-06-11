package org.tai.web.servlet.rest.report;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wiring.domain.model.RequestSummary;

@RestController
public class RequestCounterController {

    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public RequestSummary summary() {
        return new RequestSummary(0, 10);
    }

}
