package pl.valdemar.flashcardsboot.util;

public final class Mappings {
    // == constants ==
    public static final String LOGIN = "/login";
    public static final String ADD_USER = "/adduser";
    public static final String ADD_DECK = "/add-deck";
    public static final String ADD_FLASHCARD = "/add-flashcard";
    public static final String SHOW_FLASHCARDS = "/show-flashcards";
    public static final String HOME = "/";
    public static final String DELETE_DECK = "/delete-deck/{id}";
    public static final String DELETE_FLASHCARD = "/delete-flashcard";
    public static final String INDEX = "/index";
    public static final String UPDATE_DECK = "/update-deck/{id}";
    public static final String UPDATE_FLASHCARD = "/update-flashcard";
    public static final String LOGOUT = "/logout";
    public static final String STUDY = "/study";
    public static final String STUDY_SESSION = "/study-session";
    public static final String STUDY_RESULT = "/study-result";
    public static final String SEARCH = "/search";
    public static final String LOGIN_VERIFIED = "/login-verified";
    public static final String LOGIN_ERROR = "/login-error";
    public static final String VERIFY_EMAIL = "/verify/email";
    public static final String LOGIN_DISABLED = "/login-disabled";
    public static final String ACCOUNT_SETTINGS = "/account/settings";
    public static final String ACCOUNT_SETTINGS_PASSWORD = "/account/settings/password";
    public static final String ACCOUNT_SETTINGS_EMAIL = "/account/settings/email";
    public static final String REMOVE_ACCOUNT = "/account/remove";

    // == constructors ==
    private Mappings() {
    }
}
