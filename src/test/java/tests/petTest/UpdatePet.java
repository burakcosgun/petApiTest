package tests.petTest;

import helper.PetStoreHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static config.DataConstants.PET_ID;
import static config.DataConstants.PET_NAME;

public class UpdatePet {

    PetStoreHelper petStoreHelper = new PetStoreHelper();

    private String updatedName = "DummyDummy";
    @BeforeTest
    public void before() {
        petStoreHelper.createPet(PET_ID, PET_NAME);
    }

    @Test
    public void update_Pet_Name_Then_Check_Name_And_Api_Health(){
        Response response = petStoreHelper.putPet(PET_ID,updatedName, "Category1");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("name"), updatedName);
    }

    @AfterTest
    public void after() {
        petStoreHelper.deletePet(PET_ID);
    }
}
