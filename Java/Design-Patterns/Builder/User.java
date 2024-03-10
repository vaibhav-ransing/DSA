class User {

    /*
     * We cannot use final without initializing
     * initialization is done by constructor
     * means for final attributes -> constructor is mandatory
     */
    private final String id;
    private final String name;
    private final String email;

    private User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.email = userBuilder.email;
        this.name = userBuilder.name;
    }
    // private User() {
    // }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    static class UserBuilder {

        private String id;
        private String name;
        private String email;

        public UserBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }
}