package sidedish.com.config;

public class GitHubOAuthUtils {

	public static final String DNS_NAME;
	public static final String CALLBACK_URL;
	public static final String CLIENT_ID;
	public static final String CLIENT_SECRET;
	public static final String LOCATION;
	public static final String ACCESSTOKEN_API_URL;
	public static final String USER_API_URL;

	static {
		DNS_NAME = System.getenv("DNS_NAME");
		CALLBACK_URL = DNS_NAME + "/api/login/callback";
		CLIENT_ID = System.getenv("GITHUB_CLIENT_ID");
		CLIENT_SECRET = System.getenv("GITHUB_CLIENT_SECRET");
		LOCATION = "https://github.com/login/oauth/authorize?client_id=" + CLIENT_ID +
			"&redirect_uri=" + CALLBACK_URL;
		ACCESSTOKEN_API_URL = "https://github.com/login/oauth/access_token";
		USER_API_URL = "https://api.github.com/user";
	}
}
