package kr.chandol.java8inaction.chapter6;


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class subChapter1 {

    public List<Transaction> transactions = Arrays.asList(
            new Transaction(Currency.EUR, 1500.0),
            new Transaction(Currency.USD, 2300.0),
            new Transaction(Currency.EUR, 1100.0),
            new Transaction(Currency.USD, 9900.0),
            new Transaction(Currency.JPY, 7800.0),
            new Transaction(Currency.JPY, 6700.0),
            new Transaction(Currency.EUR, 5600.0)
    );

    @Test
    public void underJava8() {
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }

        System.out.println(transactionsByCurrencies);
    }

    @Test
    public void java8FunctionalStyle() {
        Map<Currency, List<Transaction>> transactionsByCurrencies = transactions
                .stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency));

        System.out.println(transactionsByCurrencies);
    }


    public static class Transaction {
        private final Currency currency;
        private final double value;

        public Transaction(Currency currency, double value) {
            this.currency = currency;
            this.value = value;
        }

        public Currency getCurrency() {
            return currency;
        }

        public double getValue() {
            return value;
        }

        @Override
        public String toString() {
            return currency + " " + value;
        }
    }

    public enum Currency {
        EUR, USD, JPY
    }
}
