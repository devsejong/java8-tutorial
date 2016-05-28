package kr.chandol.java8lecture.lecture3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static kr.chandol.java8lecture.lecture3.Transaction.transactions;

/**
 * Created by sejong on 2016. 5. 27..
 */
public class LegacyJavaToStream {

    private static void groupImperatively() {

        Map<Currency, List<Transaction>> resultCurrencies = new HashMap<>();
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = resultCurrencies.get(currency);
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                resultCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }


        System.out.println(resultCurrencies);
    }

    private static void groupFunctionally() {

        Map<Currency, List<Transaction>> transactionsByCurrencies =
                transactions.stream()
                        .collect(
                                groupingBy(Transaction::getCurrency)
                        );

        System.out.println(transactionsByCurrencies);
    }


}
