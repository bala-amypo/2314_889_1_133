@Component
public class jwtUtil{
    private final String SECRET="secret123";
    private final long EXP=86400000;
    public String generateToken(Map<String,Object>claims,String username){
        return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+EXP)).signWith(SignatureAlgorithm.HS256,SECRET).compact();
    }
    public String getUsername(String token){
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBod
    }
}