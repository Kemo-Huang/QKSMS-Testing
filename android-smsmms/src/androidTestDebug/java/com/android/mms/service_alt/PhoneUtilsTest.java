package com.android.mms.service_alt;


import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.TelephonyManager;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.rule.ServiceTestRule;

import com.android.mms.transaction.TransactionService;

import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.TimeoutException;

import static com.android.mms.service_alt.PhoneUtils.getNationalNumber;
import static org.junit.Assert.fail;

public class PhoneUtilsTest {

    @Rule
    public ServiceTestRule serviceRule = new ServiceTestRule();


    @Test
    public void getNationalNumberTest_1() throws TimeoutException {
        try {
            Intent serviceIntent =
                    new Intent(
                            ApplicationProvider.getApplicationContext(),
                            TransactionService.class);
            IBinder binder = serviceRule.bindService(serviceIntent);
            TransactionService service =
                    ((TransactionService.LocalBinder) binder).getService();
            TelephonyManager telephonyManager = (TelephonyManager) service.getSystemService(Context.TELEPHONY_SERVICE);
            getNationalNumber(telephonyManager, 1, "");
        } catch (NullPointerException e) {
            return;
        }
        fail("Null pointer exception expected.");
    }

    @Test
    public void getNationalNumberTest_2() {
        try {
            getNationalNumber(null, 0, "12345678901");
        } catch (NullPointerException e) {
            return;
        }
        fail("Null pointer exception expected.");
    }

    @Test
    public void getNationalNumberTest_3() {
        try {
            getNationalNumber(null, -1, "");
        } catch (NullPointerException e) {
            return;
        }
        fail("Null pointer exception expected.");
    }

    @Test
    public void getNationalNumberTest_4() throws TimeoutException {
        try {
            Intent serviceIntent =
                    new Intent(
                            ApplicationProvider.getApplicationContext(),
                            TransactionService.class);
            IBinder binder = serviceRule.bindService(serviceIntent);
            TransactionService service =
                    ((TransactionService.LocalBinder) binder).getService();
            TelephonyManager telephonyManager = (TelephonyManager) service.getSystemService(Context.TELEPHONY_SERVICE);
            getNationalNumber(telephonyManager, 86, "18929357397");
        } catch (NullPointerException e) {
            return;
        }
        fail("Null pointer exception expected.");
    }

    @Test
    public void getNationalNumberTest_5() throws TimeoutException {
        try {
            Intent serviceIntent =
                    new Intent(
                            ApplicationProvider.getApplicationContext(),
                            TransactionService.class);
            IBinder binder = serviceRule.bindService(serviceIntent);
            TransactionService service =
                    ((TransactionService.LocalBinder) binder).getService();
            TelephonyManager telephonyManager = (TelephonyManager) service.getSystemService(Context.TELEPHONY_SERVICE);
            getNationalNumber(telephonyManager, -1, "00000000000");
        } catch (NullPointerException e) {
            return;
        }
        fail("Null pointer exception expected.");
    }

}