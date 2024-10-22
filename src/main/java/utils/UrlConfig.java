package utils;

public class UrlConfig {
    public static final String BASE_URL = "http://localhost:3000/";
    public static final String CONTACT_PAGE_URL = BASE_URL + "contact";
    public static final String LOGIN_PAGE_URL = BASE_URL + "auth?mode=login";
    public static final String SIGNUP_PAGE_URL = BASE_URL + "auth?mode=signup";
    public static final String EVENTS_PAGE_URL = BASE_URL + "events";
    public static final String CREATE_NEW_EVENT_PAGE_URL = EVENTS_PAGE_URL + "/new";
}
