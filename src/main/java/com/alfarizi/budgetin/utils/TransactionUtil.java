package com.alfarizi.budgetin.utils;

import com.alfarizi.budgetin.model.Transaction;

import java.util.Calendar;

public class TransactionUtil {

    public static boolean isDateMatch(Transaction transaction, Integer year, Integer month) {
        if (year == null || month == null) return true;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(transaction.getDate());
        int transactionMonth = calendar.get(Calendar.MONTH);
        int transactionYear = calendar.get(Calendar.YEAR);
        return transactionMonth == month && transactionYear == year;
    }
}
