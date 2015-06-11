package org.tai.web.servlet.user.transaction;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * @author Przemyslaw Dadel
 */
public class UserTransaction {

    private final String accountNumber;
    private final DateTime transactionDate;
    private final BigDecimal transactionValue;

    public UserTransaction(String accountNumber, DateTime transactionDate, BigDecimal transactionValue) {
        this.accountNumber = accountNumber;
        this.transactionDate = transactionDate;
        this.transactionValue = transactionValue;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public BigDecimal getTransactionValue() {
        return transactionValue;
    }


    public DateTime getTransactionDate() {
        return transactionDate;
    }
}
