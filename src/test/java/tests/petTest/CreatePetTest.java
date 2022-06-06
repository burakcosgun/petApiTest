package tests.petTest;

import helper.PetStoreHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static config.DataConstants.*;


public class CreatePetTest {
    PetStoreHelper petStoreHelper = new PetStoreHelper();

    private static int invalidId = -4;

    @Test(priority = 1)
    public void create_New_Pet_Then_Check_Id_And_Api_Health() {
        Response response = petStoreHelper.createPet(PET_ID, PET_NAME);

        Assert.assertEquals(response.statusCode(), STATUS_CODE);
        Assert.assertEquals(response.jsonPath().get("id"), PET_ID);
    }

    @Test(priority = 2)
    public void create_New_Pet_With_Invalid_Id_Then_Check_Id_And_Status_Code() {
        Response response = petStoreHelper.createPet(PET_ID, PET_NAME);
        Assert.assertEquals(response.statusCode(),  STATUS_CODE);
        Assert.assertEquals(response.jsonPath().get("id"), invalidId);
    }

    @AfterTest
    public void after() {
        petStoreHelper.deletePet(PET_ID);
    }
}
