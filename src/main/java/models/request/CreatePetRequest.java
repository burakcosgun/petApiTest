package models.request;

import java.util.ArrayList;

public class CreatePetRequest {
        public Integer id;
        public Category category;
        public String name;
        public ArrayList<String> photoUrls;
        public ArrayList<Tag> tags;
        public String status;

    private CreatePetRequest(Builder builder) {
        id = builder.id;
        name = builder.name;
        category = builder.category;
        photoUrls = builder.photoUrls;
        tags = builder.tags;
        status = builder.status;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Category {
        public Integer id = 1;
        public String name = "";

        private Category(Builder builder) {
            id = builder.id;
            name = builder.name;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static final class Builder {
            public String name;
            private Integer id;

            private Builder() {
            }

            public Builder withId(Integer val) {
                id = val;
                return this;
            }

            public Builder withName(String val) {
                name = val;
                return this;
            }

            public Category build() {
                return new Category(this);
            }
        }
    }

    public static class Tag{
        public Integer id;
        public String name;

        private Tag(Builder builder) {
            id = builder.id;
            name = builder.name;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static final class Builder {
            public Integer id;
            public String name;

            private Builder() {
            }

            public Builder withId(Integer val) {
                id = val;
                return this;
            }

            public Builder withName(String val) {
                name = val;
                return this;
            }

            public Tag build() {
                return new Tag(this);
            }
        }
    }

    public static final class Builder {
        public String name;
        private Integer id;
        private Category category;
        private ArrayList<String> photoUrls;
        private ArrayList<Tag> tags;
        private String status;

        private Builder() {
        }

        public Builder withId(Integer val) {
            id = val;
            return this;
        }

        public Builder withCategory(Category val) {
            category = val;
            return this;
        }

        public Builder withPhotoUrls(ArrayList<String> val) {
            photoUrls = val;
            return this;
        }

        public Builder withTags(ArrayList<Tag> val) {
            tags = val;
            return this;
        }

        public Builder withStatus(String val) {
            status = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public CreatePetRequest build() {
            return new CreatePetRequest(this);
        }
    }
}
