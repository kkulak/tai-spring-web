package org.tai.web.servlet.rest.report;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wiring.application.TransactionService;
import wiring.domain.model.Account;
import wiring.domain.model.Transaction;
import wiring.domain.model.TransactionSummary;

/**
 * @author Przemyslaw Dadel
 * @author Marek Konieczny
 */
@RestController
@RequestMapping(value = "/transactions")
public class RestReportController {

	private final TransactionService transactionService;

    @Autowired
    public RestReportController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    public Collection<TransactionSummary> summary() {
        return transactionService.createTransactionSummary();
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
    public Collection<TransactionSummary> transactions(@PathVariable("accountId") String accountId) {
        return transactionService.createTransactionSummary(Account.of(accountId));
    }

}
