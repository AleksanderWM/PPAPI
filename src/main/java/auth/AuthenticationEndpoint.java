/*
 * Inspiration found from the response to a post on stack overflow.
 *https://stackoverflow.com/questions/26777083/best-practice-for-rest-token-based-authentication-with-jax-rs-and-jersey
 */
package auth;

import brugerautorisation.data.Bruger;
import brugerautorisation.transport.soap.Brugeradmin;
import java.net.URL;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import entities.Users;
import java.security.*;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.util.Date; 

@Path("/authentication")
public class AuthenticationEndpoint{


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(Users credentials) {
        String username = credentials.getUserID();
        String password = credentials.getPassword();

        try {
            // Authenticate the user using the credentials provided
            authenticate(username, password); 
            // Issue a token for the user
            String token = issueToken(username);
            System.out.print("Fejl herefter");
            // Return the token on the response
           return Response.ok(token).build();

        } catch (Exception e) {
           return Response.status(Response.Status.FORBIDDEN).build();
        }      
    }

    private void authenticate(String username, String password) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
         try { 
        Brugeradmin ba;

            URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
		QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
		Service service = Service.create(url, qname);
		ba = service.getPort(Brugeradmin.class);
            Bruger bruger = ba.hentBruger(username, password);           
            } catch (Exception e) {
           Response.status(Response.Status.UNAUTHORIZED).build();
        }   
        }
    

    private String issueToken(String username) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
        //Sample method to construct a JWT
 
    long nowMillis = System.currentTimeMillis();
    long ttlMillis = 360000000;
    Date now = new Date(nowMillis);
    long expMillis = nowMillis + ttlMillis;
        Date exp = new Date(expMillis);
 
    Key key = MacProvider.generateKey();
    //Let's set the JWT Claims
    String token = Jwts.builder()
                                .setSubject(username)
                                .setId(username)
                                .signWith(SignatureAlgorithm.HS256, key)
                                .setExpiration(exp)
                                .compact();
    //if it has been specified, let's add the expiration
        return token;
    }

 
}