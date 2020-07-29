package com.mdsol.raa.trustedticketgenerator.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Amol Patil apatil@mdsol.com
 */
@Service
public class TicketGeneratorService {
    private Logger m_logger = LoggerFactory.getLogger(this.getClass().getName());

    public String getTrustedTicket(String serverForTokenCreation, String userName, String site) throws Exception {
        try (CloseableHttpClient httpclient = createAcceptSelfSignedCertificateClient()) {
            StringBuffer data = new StringBuffer();
            data.append(URLEncoder.encode("username", "UTF-8"));
            data.append("=");
            data.append(URLEncoder.encode(userName, "UTF-8"));
            data.append("&");
            data.append(URLEncoder.encode("target_site", "UTF-8"));
            data.append("=");
            data.append(URLEncoder.encode(site, "UTF-8"));

            HttpPost httpPost = new HttpPost(serverForTokenCreation + "/trusted?" + data);
            m_logger.info("Executing request " + httpPost.getRequestLine());

            CloseableHttpResponse response = httpclient.execute(httpPost);
            m_logger.info("Response of closable: " + response.toString());
            String bodyAsString = EntityUtils.toString(response.getEntity());
            m_logger.info("Response as a body: " + bodyAsString);
            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode == 200) {
                m_logger.info("successfully created the token: {} for user:{}" + bodyAsString + " " + userName);
                return bodyAsString;
            } else {
                m_logger.info("Error while creating a token for user" + response.getStatusLine() + userName);
            }

        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException | IOException e) {
            throw new Exception("Error while getting token" + e.toString(), e);
        }
        return null;
    }


    private static CloseableHttpClient createAcceptSelfSignedCertificateClient()
            throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {

        // use the TrustSelfSignedStrategy to allow Self Signed Certificates
        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadTrustMaterial(new TrustSelfSignedStrategy())
                .build();

        // we can optionally disable hostname verification.
        // if you don't want to further weaken the security, you don't have to include this.
        HostnameVerifier allowAllHosts = new NoopHostnameVerifier();

        // create an SSL Socket Factory to use the SSLContext with the trust self signed certificate strategy
        // and allow all hosts verifier.
        SSLConnectionSocketFactory connectionFactory = new SSLConnectionSocketFactory(sslContext, allowAllHosts);

        // finally create the HttpClient using HttpClient factory methods and assign the ssl socket factory
        return HttpClients
                .custom()
                .setSSLSocketFactory(connectionFactory)
                .build();
    }


}
