package helper;

import client.RestAssuredBase;
import config.ApiConstants;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import models.request.CreatePetRequest;
import models.response.CreatePetResponse;

import static config.ApiConstants.PetStoreEndPoints.PET;

public class PetStoreHelper extends RestAssuredBase {


    public PetStoreHelper() {
        super(ApiConstants.PetStore.BASE_URL);
    }

    public Response createPet(Integer id, String name) {
        CreatePetRequest.Category category = CreatePetRequest.Category.newBuilder().build();
        CreatePetRequest createPetRequest = CreatePetRequest.newBuilder()
                .withId(id)
                .withCategory(category)
                .withName(name)
                .build();
        return post("pet", createPetRequest);
    }

    public CreatePetResponse createPetResponse(Integer id, String name) {
        return createPet(id, name)
                .getBody().as(CreatePetResponse.class);
    }

    public Response getPet(Integer id) {
        Response response = get(PET + "/", id);
        System.out.println(response.getBody().asString());
        return response;
    }

    public Response putPet(Integer id, String petName, String categoryName) {
        CreatePetRequest.Category category = CreatePetRequest.Category.newBuilder()
                .withName(categoryName)
                .build();

        CreatePetRequest createPetRequest = CreatePetRequest.newBuilder()
                .withId(id)
                .withCategory(category)
                .withName(petName)
                .build();
        return put(PET, createPetRequest);
    }

    public Response deletePet(Integer id) {
        Response response = delete(PET + "/", id);
        System.out.println(response.getBody().asString());
        return response;
    }
}
