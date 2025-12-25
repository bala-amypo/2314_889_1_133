@Component
public class jwtUtil{
    private final String SECRET="secret123";
    private final long EXP=86400000;
    public String generateToken(Map<String,Object>claims,String username){
        return Jwts.builder().setClaims(claims).setSubject(username)
    }
}