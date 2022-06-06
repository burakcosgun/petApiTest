package tests.petTest;

import helper.PetStoreHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static config.DataConstants.*;

public class DeletePet {

    PetStoreHelper petStoreHelper = new PetStoreHelper();

    @BeforeTest
    public void before() {
        petStoreHelper.createPet(PET_ID, PET_NAME);
    }

    @Test
    public void delete_Pet_With_Id_Then_Check_Params_And_Api_Health(){
        Response response = petStoreHelper.deletePet(PET_ID);
        Assert.assertEquals(response.jsonPath().get("code"), STATUS_CODE);
        Assert.assertEquals(response.jsonPath().get("message"), String.valueOf(PET_ID));
        Assert.assertEquals(response.getStatusCode(), STATUS_CODE);
    }

    @Test(priority = 2)
    public void delete_Pet_With_Deleted_Id_Then_Check_Id_And_Status_Code() {
        Response response = petStoreHelper.deletePet(PET_ID);
        Assert.assertEquals(response.statusCode(), STATUS_CODE_NOT_FOUND);
    }
}
