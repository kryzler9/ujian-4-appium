package com.juaracoding.ujian;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class UjianTestCatatanKeuangan {

        private AndroidDriver driver;

        @BeforeClass
        public void setUp () throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 2 API 30");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("platformVersion", "11");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("noReset", true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dc);

    }

    @AfterClass
    public void finish () {
        delay(3);
        driver.quit();
    }

    @Test(priority = 1)
    public void testPemasukanGaji() {
        delay(12);
        driver.findElementById("com.chad.financialrecord:id/fabMenu").click(); // Tambah fitur pemasukan/pengeluaran
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/btnIncome").click(); //Button Pemasukan
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/etAmount").click();
        driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("3000000");
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/etNote").click();
        driver.findElementById("com.chad.financialrecord:id/etNote").sendKeys("Gaji Masuk");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/btSave").click(); //Simpan
        delay(2);
        String actual = driver.findElementById("com.chad.financialrecord:id/tvBalance").getText();
        Assert.assertEquals(actual, "3.000.000"); //assert sesusai saldo berubah

    }

    @Test(priority = 2)
    public void testPemasukanTabungan() {
        delay(5);
        driver.findElementById("com.chad.financialrecord:id/fabMenu").click();
        delay(1);
        driver.findElementById("com.chad.financialrecord:id/btnIncome").click(); //Button Pemasukan
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/spCategory").click(); //Klik untuk pilih kategori
        delay(2);
        driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvName\" and @text=\"Tabungan\"]").click(); //Memilih kategori tabungan
        delay(3);
        driver.findElementById("com.chad.financialrecord:id/etAmount").click();
        driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("1000000");
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/etNote").click();
        driver.findElementById("com.chad.financialrecord:id/etNote").sendKeys("Tabungan");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        delay(3);
        driver.findElementById("com.chad.financialrecord:id/btSave").click(); //Simpan
        delay(3);
        String actual = driver.findElementById("com.chad.financialrecord:id/tvBalance").getText();
        Assert.assertEquals(actual, "4.000.000"); //assert sesusai saldo berubah
    }

    @Test(priority = 3)
    public void testPengeluaranMakan() {
        delay(5);
        driver.findElementById("com.chad.financialrecord:id/fabMenu").click(); // Tambah fitur pemasukan/pengeluaran
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/etAmount").click();
        driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("100000");
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/etNote").click();
        driver.findElementById("com.chad.financialrecord:id/etNote").sendKeys("Makan Siang");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/btSave").click(); //Simpan
        delay(2);
        String actual = driver.findElementById("com.chad.financialrecord:id/tvBalance").getText();
        Assert.assertEquals(actual, "3.900.000"); //assert sesusai saldo berubah

    }

    @Test(priority = 4)
    public void testPengeluaranPakaian() {
        delay(5);
        driver.findElementById("com.chad.financialrecord:id/fabMenu").click(); // Tambah fitur pemasukan/pengeluaran
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/spCategory").click();
        delay(2);
        driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvName\" and @text=\"Pakaian\"]").click();
        delay(1);
        driver.findElementById("com.chad.financialrecord:id/etAmount").click();
        driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("400000");
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/etNote").click();
        driver.findElementById("com.chad.financialrecord:id/etNote").sendKeys("Pakaian");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/btSave").click(); //Simpan
        delay(2);
        String actual = driver.findElementById("com.chad.financialrecord:id/tvBalance").getText();
        Assert.assertEquals(actual, "3.500.000"); //assert sesusai saldo berubah
    }

    @Test(priority = 5)
    public void testPengeluaranPajak() {
        delay(5);
        driver.findElementById("com.chad.financialrecord:id/fabMenu").click(); // Tambah fitur pemasukan/pengeluaran
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/spCategory").click();
        delay(2);
        driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvName\" and @text=\"Pajak\"]").click();
        delay(1);
        driver.findElementById("com.chad.financialrecord:id/etAmount").click();
        driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("1500000");
        delay(3);
        driver.findElementById("com.chad.financialrecord:id/etNote").click();
        driver.findElementById("com.chad.financialrecord:id/etNote").sendKeys("Pajak");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/btSave").click(); //Simpan
        delay(2);
        String actual = driver.findElementById("com.chad.financialrecord:id/tvBalance").getText();
        Assert.assertEquals(actual, "2.000.000"); //assert sesusai saldo berubah

    }

    @Test(priority = 6)
    public void testCekSaldo() {
        delay(5);
        String actual = driver.findElementById("com.chad.financialrecord:id/tvBalance").getText();
        Assert.assertEquals(actual, "2.000.000");
        System.out.println("Saldo setelah pemasukan dan pengeluaran: "+actual);
    }

    public void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
