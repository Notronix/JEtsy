package com.notronix.etsy.api.authentication.model;

import com.notronix.etsy.api.AppKey;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.notronix.etsy.api.MethodUtils.addIfProvided;
import static java.util.Objects.requireNonNull;

public interface OAuthConnector
{
    String BASE_URL = "https://www.etsy.com/oauth/connect";

    Function<String, String> urlEncoder = s -> {
        try {
            return URLEncoder.encode(requireNonNull(s), StandardCharsets.UTF_8.name())
                    .replace("+", "-")
                    .replace("/", "_")
                    .replace("=", "");
        }
        catch (UnsupportedEncodingException ex) {
            throw new IllegalArgumentException("url encoding error", ex);
        }
    };

    String getState();

    String getCodeVerifier();

    String getCodeChallenge();

    String getConnectionURL(AppKey appKey, String redirectURL, Set<EtsyScope> scopes);

    static OAuthConnector withValues(String state, String verifier, String challenge) {
        return new OAuthConnector()
        {
            @Override
            public String getState() {
                return state;
            }

            @Override
            public String getCodeVerifier() {
                return verifier;
            }

            @Override
            public String getCodeChallenge() {
                return challenge;
            }

            @Override
            public String getConnectionURL(AppKey appKey, String redirectURL, Set<EtsyScope> scopes) {
                String url = addIfProvided(BASE_URL, "response_type", "code");
                url = addIfProvided(url, "client_id", requireNonNull(appKey.getValue()));
                url = addIfProvided(url, "redirect_uri", urlEncoder.apply(requireNonNull(redirectURL)));
                url = addIfProvided(url, "scope", requireNonNull(scopes).stream().map(Enum::name)
                        .collect(Collectors.joining("%20")));
                url = addIfProvided(url, "state", state);
                url = addIfProvided(url, "code_challenge", challenge);
                url = addIfProvided(url, "code_challenge_method", "S256");

                return url;
            }
        };
    }
}
