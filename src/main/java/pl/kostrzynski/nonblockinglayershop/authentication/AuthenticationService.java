package pl.kostrzynski.nonblockinglayershop.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import pl.kostrzynski.nonblockinglayershop.security.jwt.JwtService;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class AuthenticationService {

    private final JwtService jwtService;

    private final ReactiveAuthenticationManager authenticationManager;

    public Mono<String> authenticate(AuthenticationRequest request) {

        return authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()))
                .map(auth -> jwtService.create(auth.getName()));
    }
}
