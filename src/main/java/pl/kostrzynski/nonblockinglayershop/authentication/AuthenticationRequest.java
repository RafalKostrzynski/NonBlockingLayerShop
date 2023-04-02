package pl.kostrzynski.nonblockinglayershop.authentication;

import jakarta.validation.constraints.NotNull;

record AuthenticationRequest(@NotNull String username, @NotNull String password) {
}
