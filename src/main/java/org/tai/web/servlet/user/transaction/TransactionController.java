package org.tai.web.servlet.user.transaction;

import java.util.Collection;

import org.joda.time.DateTime;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import wiring.application.TransactionService;
import wiring.domain.model.Account;
import wiring.domain.model.Transaction;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;


/**
 * @author Przemyslaw Dadel
 * @author Marek Konieczny
 */
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public ModelAndView prepareEnlistNewTransaction() {
        return new ModelAndView("enlist", "command", new NewUserTransaction());
    }

    public View enlistNewTransaction(NewUserTransaction newUserTransaction, RedirectAttributes redirectAttributes) {
        final Transaction transaction = createTransaction(newUserTransaction);
        transactionService.enlistTransaction(transaction);

        redirectAttributes.addFlashAttribute("status", "success");

        return new RedirectView("/user/transactions/list", true);
    }

    public ModelAndView listTransactions(ModelAndView modelAndView) {
        modelAndView.addObject("transactions", toUglyObjectsWithGetters(transactionService.listTransactions()));
        modelAndView.setViewName("list");
        return modelAndView;
    }


    private Transaction createTransaction(NewUserTransaction newUserTransaction) {
        return new Transaction(Account.of(newUserTransaction.getAccountNumber()), DateTime.now(), newUserTransaction.getTransactionValue());
    }

    private Collection<UserTransaction> toUglyObjectsWithGetters(Collection<Transaction> transactions) {
        return FluentIterable.from(transactions).transform(new Function<Transaction, UserTransaction>() {
            @Override
            public UserTransaction apply(Transaction input) {
                return new UserTransaction(input.account().number(), input.transactionDate(), input.amount());
            }
        }).toList();
    }

}
