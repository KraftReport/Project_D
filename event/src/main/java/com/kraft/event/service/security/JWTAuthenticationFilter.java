//package com.kraft.event.service.security;
//
//import com.kraft.event.repository.TokenRepository;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//@RequiredArgsConstructor
//public class JWTAuthenticationFilter extends OncePerRequestFilter {
//
//    private final JwtService jwtService;
//    private final UserDetailsService userDetailsService;
//    private final TokenRepository tokenRepository;
//
//    @Override
//    protected void doFilterInternal(@NonNull HttpServletRequest request,
//                                    @NonNull HttpServletResponse response,
//                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
//
//        final var authHeader = request.getHeader("Authorization");
//
//        if(authHeader==null || !authHeader.startsWith("Bearer")){
//            filterChain.doFilter(request,response);
//            return;
//        }
//
//        final var jwt = authHeader.substring(7);
//        final var email = jwtService.extractUserName(jwt);
//
//        if(email!=null && SecurityContextHolder.getContext().getAuthentication()!=null){
//            var userDetail = this.userDetailsService.loadUserByUsername(email);
//            var foundToken = tokenRepository.findByToken(jwt);
//            var isValidInDatabase = !foundToken.isExpired() && !foundToken.isRevoked();
//            if(jwtService.validateToken(jwt,userDetail)&&isValidInDatabase){
//                var authToken = new UsernamePasswordAuthenticationToken(
//                        userDetail,null,userDetail.getAuthorities()
//                );
//                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//            }
//        }
//
//        filterChain.doFilter(request,response);
//
//    }
//}
