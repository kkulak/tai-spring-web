package org.tai.web.servlet.rest.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tai.web.servlet.PerSessionRequestCounter;
import wiring.domain.model.RequestSummary;

@RestController
public class RequestCounterController {
    @Autowired
    private PerSessionRequestCounter counter;

    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public RequestSummary summary() {
        return new RequestSummary(counter.requestCount(), 10);
    }

}
