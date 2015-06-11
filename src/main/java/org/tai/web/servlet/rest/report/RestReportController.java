package org.tai.web.servlet.rest.report;

import java.util.Collection;

import wiring.application.TransactionService;
import wiring.domain.model.TransactionSummary;

/**
 * @author Przemyslaw Dadel
 * @author Marek Konieczny
 */
public class RestReportController {

	private final TransactionService transactionService;

    public RestReportController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public Collection<TransactionSummary> summary() {
        return transactionService.createTransactionSummary();
    }

}
