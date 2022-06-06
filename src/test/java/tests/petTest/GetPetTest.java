package tests.petTest;

import helper.PetStoreHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import static config.DataConstants.*;

public class GetPetTest {
    PetStoreHelper petStoreHelper = new PetStoreHelper();

    private Integer petId;
    private String petName;

    @BeforeTest
    public void before() {
        petId = petStoreHelper.createPetResponse(PET_ID, PET_NAME).id;
        petName = petStoreHelper.createPetResponse(PET_ID, PET_NAME).name;
    }

    @Test(priority = 1)
    public void get_Pet_With_Id_Then_Check_Name_And_Api_Health(){
        Response response = petStoreHelper.getPet(petId);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("id"), petId);
        Assert.assertEquals(response.jsonPath().get("name"), petName);
    }

    @Test(priority = 2)
    public void get_Pet_With_Wrong_Id_Then_Check_Status_And_Message() {
        petStoreHelper.deletePet(WRONG_PET_ID);
        Response response = petStoreHelper.getPet(WRONG_PET_ID);
        Assert.assertEquals(response.statusCode(), STATUS_CODE_NOT_FOUND);
        Assert.assertEquals(response.jsonPath().get("message"), "Pet not found");
    }

    @AfterTest
    public void after() {
        petStoreHelper.deletePet(PET_ID);
    }
}
