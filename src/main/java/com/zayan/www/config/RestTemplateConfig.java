package com.zayan.www.config;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Configuration
public class RestTemplateConfig {

    @Value("${restTemplateConfig.readTimeout:20000}")
    private Integer readTimeout;
    @Value("${restTemplateConfig.connectTimeout:20000}")
    private Integer connectTimeout;
    @Value("${restTemplateConfig.connectionRequestTimeout:5000}")
    private Integer connectionRequestTimeout;

    @Value("${restTemplateConfig.connectionsMaxTotal:1000}")

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(simpleClientHttpRequestFactory());
    }

    private ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestWithBodyFactory();
        requestFactory.setHttpClient(httpClient);

        requestFactory.setReadTimeout(readTimeout);
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setConnectionRequestTimeout(connectionRequestTimeout);

        return requestFactory;
    }

    private static final class HttpComponentsClientHttpRequestWithBodyFactory extends HttpComponentsClientHttpRequestFactory {
        @Override
        protected HttpUriRequest createHttpUriRequest(HttpMethod httpMethod, URI uri) {
            if (httpMethod == HttpMethod.GET) {
                return new HttpGetRequestWithEntity(uri);
            }
            return super.createHttpUriRequest(httpMethod, uri);
        }

        private static final class HttpGetRequestWithEntity extends HttpEntityEnclosingRequestBase {
            HttpGetRequestWithEntity(final URI uri) {
                super.setURI(uri);
            }

            @Override
            public String getMethod() {
                return HttpMethod.GET.name();
            }
        }
    }
}
