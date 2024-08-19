package ai.rnt.auth2.server.entity;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.config.ClientSettings;
import org.springframework.security.oauth2.server.authorization.config.TokenSettings;

public class OAuthClient {
	private String id;
	private String clientId;
	private Instant clientIdIssuedAt;
	private String clientSecret;
	private Instant clientSecretExpiresAt;
	private String clientName;
	private Set<String> clientAuthenticationMethods;
	private Set<String> authorizationGrantTypes;
	private Set<String> redirectUris;
	private Set<String> scopes;
	private ClientSettings clientSettings;
	private TokenSettings tokenSettings;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Instant getClientIdIssuedAt() {
		return clientIdIssuedAt;
	}

	public void setClientIdIssuedAt(Instant clientIdIssuedAt) {
		this.clientIdIssuedAt = clientIdIssuedAt;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public Instant getClientSecretExpiresAt() {
		return clientSecretExpiresAt;
	}

	public void setClientSecretExpiresAt(Instant clientSecretExpiresAt) {
		this.clientSecretExpiresAt = clientSecretExpiresAt;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Set<String> getClientAuthenticationMethods() {
		return clientAuthenticationMethods;
	}

	public void setClientAuthenticationMethods(Set<String> clientAuthenticationMethods) {
		this.clientAuthenticationMethods = clientAuthenticationMethods;
	}

	public Set<String> getAuthorizationGrantTypes() {
		return authorizationGrantTypes;
	}

	public void setAuthorizationGrantTypes(Set<String> authorizationGrantTypes) {
		this.authorizationGrantTypes = authorizationGrantTypes;
	}

	public Set<String> getRedirectUris() {
		return redirectUris;
	}

	public void setRedirectUris(Set<String> redirectUris) {
		this.redirectUris = redirectUris;
	}

	public Set<String> getScopes() {
		return scopes;
	}

	public void setScopes(Set<String> scopes) {
		this.scopes = scopes;
	}

	public ClientSettings getClientSettings() {
		return clientSettings;
	}

	public void setClientSettings(ClientSettings clientSettings) {
		this.clientSettings = clientSettings;
	}

	public TokenSettings getTokenSettings() {
		return tokenSettings;
	}

	public void setTokenSettings(TokenSettings tokenSettings) {
		this.tokenSettings = tokenSettings;
	}

	public RegisteredClient toRegisteredClient() {
		return RegisteredClient.withId(this.id != null ? this.id : UUID.randomUUID().toString()).clientId(this.clientId)
				.clientIdIssuedAt(this.clientIdIssuedAt).clientSecret(this.clientSecret)
				.clientSecretExpiresAt(this.clientSecretExpiresAt).clientName(this.clientName)
				.clientAuthenticationMethods(e -> e.addAll(this.clientAuthenticationMethods.stream()
						.map(ClientAuthenticationMethod::new).collect(Collectors.toSet())))
				.authorizationGrantTypes(grants -> grants.addAll(this.authorizationGrantTypes.stream()
						.map(AuthorizationGrantType::new).collect(Collectors.toSet())))
				.redirectUris(uris -> uris.addAll(this.redirectUris)).scopes(scopes -> scopes.addAll(this.scopes))
				.clientSettings(this.clientSettings).tokenSettings(this.tokenSettings).build();
	}
}
