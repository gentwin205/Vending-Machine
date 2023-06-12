package com.techelevator.view;

import com.techelevator.VendingMachineCLI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VendingMachineCLITest {

    private File srcFile;
    private Path destFilePath = Paths.get("vendingmachine.csv");
    private VendingMachineCLI vend;

    @Before
    public void setup(){
        File srcfile = new File("vendingmachine.csv");
        vend = new VendingMachineCLI();

    }
    @Test
    public void itemDoesNotExist(){
        String sut = "A6";
        String expected ="Item does not exist please select another item.\n";



    }
    @Test
    public void itemSoldOut(){
        vend.dispense();

    }
    @Test
    public void insufficientFunds(){

    }
    @Test
    public void slotIsLowerCase(){

    }
    @Test
    public void chipSoundIsCorrect(){

    }
    @Test
    public void changeIsCorrectAfterBuyingA4(){

    }
    @Test
    public void currentMoneyResetsTo0AfterChangeIsGiven(){

    }
}
